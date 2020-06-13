package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Customer;
import model.DarkMode;
import model.HotelRepo;
import model.UsersRepo;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
// TODO - DIVISIBLE & ABLE SHEN SIGNIN/SIGNUP
public class Start {
	private JFrame frame;
	JButton signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");		
	JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DE\u05D4");
//CUSTOMER DB
	public UsersRepo customers;

//HELLO LABEL
	public JLabel wellcome = new JLabel("Hello guest !");
// LOGED USER
	public Customer user;
//HOTELS REPO
	public HotelRepo hotelDB;
//DARK MODE
	public int darkFlag = 0;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
//RADIO BTNS
	public ArrayList<JRadioButton> radioBtns = new ArrayList<JRadioButton>();
//PANELS
	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadAllData() {
		user = new Customer(null, null, null, null, null, false, null, 0, 0, 0);
		customers=UsersRepo.getInstance("Members/Customers.txt");
		hotelDB =HotelRepo.getInstance("Hotels/hotels.txt");
		fixDays();
		System.out.println("all data is set");
	}
	
	public void fixDays() {
		LocalDateTime now = LocalDateTime.now();
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date d = null;
		String dateStr = String.valueOf(now.getDayOfMonth()) +'/'+String.valueOf(now.getMonthValue())+'/'+String.valueOf(now.getYear());
		SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yy");
		try {
			d= dateFormat.parse(dateStr);
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		String previousDate = dateFormat.format(d.getTime() - MILLIS_IN_DAY);
		
		Date prev = null;
		try{
			prev = dateFormat.parse(previousDate);
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		hotelDB.fixHotelsDates(prev);
	}
	
	public Start() {
		loadAllData();
		setUI();
		setHotelList();//HOTEL PANELS MANAGMENTS
		DarkMode d = new DarkMode();
		d.setLightMode(frame, labels, btns, radioBtns, panels);
	}

	public void setUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		signInBtn.setBounds(410, 19, 110, 23);
		frame.getContentPane().add(signInBtn);
		btns.add(signInBtn);
		
		signUpBtn.setBounds(410, 72, 110, 23);
		frame.getContentPane().add(signUpBtn);
		btns.add(signUpBtn);
		
		labels.add(wellcome);
		wellcome.setBounds(420, 153, 89, 44);
		frame.getContentPane().add(wellcome);
		
		JButton disconnectBtn = new JButton("\u05D4\u05EA\u05E0\u05EA\u05E7");
		disconnectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.duplicate(null, null, null, null, null, false, null, 0, 0, 0);
				wellcome.setText("Hello guest!");
				signInBtn.setVisible(true);
				signUpBtn.setVisible(true);
			}
		});
		disconnectBtn.setBounds(410, 129, 110, 23);
		disconnectBtn.setVisible(false);
		frame.getContentPane().add(disconnectBtn);
		btns.add(disconnectBtn);
		
		
		JRadioButton darkModeRadio = new JRadioButton("Dark mode");		
		JRadioButton lightMode = new JRadioButton("Light mode");
		
		radioBtns.add(lightMode);
		radioBtns.add(darkModeRadio);

		lightMode.setSelected(true);
		lightMode.setBounds(388, 209, 155, 29);
		frame.getContentPane().add(lightMode);
		
		darkModeRadio.setBounds(388, 273, 155, 29);
		frame.getContentPane().add(darkModeRadio);
		
		lightMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(darkFlag == 1) {
					DarkMode d = new DarkMode();
					d.setLightMode(frame, labels, btns, radioBtns, panels);
					darkModeRadio.setSelected(false);
					lightMode.setSelected(true);
					darkFlag = 0;
				}
				lightMode.setSelected(true);
			}
		});
		
		darkModeRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(darkFlag == 0) {
					DarkMode d = new DarkMode();
					d.setDarkMode(frame, labels, btns, radioBtns, panels);
					darkModeRadio.setSelected(true);
					lightMode.setSelected(false);
					darkFlag = 1;
				}
				darkModeRadio.setSelected(true);
			}
		});
	//SIGN UP
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp t = new SignUp(customers, hotelDB, wellcome, user, signInBtn, signUpBtn, disconnectBtn, darkFlag);
				t.signUpForm(customers, hotelDB, wellcome, user, signInBtn, signUpBtn, disconnectBtn, darkFlag);
			}
		});
	//SIGN IN
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn t = new SignIn(customers, wellcome, user, hotelDB, signInBtn, signUpBtn, disconnectBtn, darkFlag);
				t.signInForm(customers, wellcome, user, hotelDB, signInBtn, signUpBtn, disconnectBtn, darkFlag);
			}
		});
	//ON CLOSE
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				hotelDB.saveData();
				customers.setData();
		    }
		});
	}
	
//MANAGE PANELS	
	public void setHotelList() {
		ActionListener listener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					int index = Integer.parseInt(((JButton) e.getSource()).getName());
		            Order t = new Order(hotelDB.hotels.get(index));
		            t.orderForm(hotelDB.hotels.get(index));
		        }
			}
		};
		
		int i, counter = hotelDB.hotels.size();
		JPanel[] p = new JPanel[counter];//HOTEL COUNTER
		JLabel[] lbs = new JLabel[counter];
		JButton[] b = new JButton[counter];
		for(i = 0; i < counter; i++) {//change to hotelDB
			
			p[i] = new JPanel();
			b[i] = new JButton("Order now!");
			lbs[i]=new JLabel(hotelDB.hotels.get(i).toString());//hotel name
			
			
		    b[i].addActionListener(listener);
		    b[i].setName(String.valueOf(i));
		    
		    lbs[i].setPreferredSize(new Dimension(200, 50));
		    b[i].setPreferredSize(new Dimension(150, 30));

		    p[i].setBounds(10, i*(110 + 10) + 10, 250, 110);
			p[i].setBorder(BorderFactory.createLineBorder(Color.black));

			p[i].add(lbs[i]);
			p[i].add(b[i]);
			btns.add(b[i]);
			labels.add(lbs[i]);
			panels.add(p[i]);
			frame.getContentPane().add(p[i]);
		}
		
		frame.getContentPane().remove(p[0]);
	}
}
