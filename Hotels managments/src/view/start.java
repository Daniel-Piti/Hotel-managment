package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Customer;
import model.Hotel;
import model.HotelRepo;
import model.MyDate;
import model.UsersRepo;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

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
//PREV DATE
	public MyDate prevDate = new MyDate(0, 0, 0);
//HOTELS REPO
	public HotelRepo hotelDB;

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
		customers = new UsersRepo("Members/Customers.txt");
		hotelDB = new HotelRepo("Hotels/hotels.txt");
		LocalDateTime now = LocalDateTime.now();
		prevDate.loadPrevDate();
		int diff = prevDate.getDaysDiff(new MyDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear()));
		hotelDB.fixHotelsDates(diff);

		System.out.println("all data is set");
	}
	
	public Start() {
		loadAllData();
		setUI();
		setHotelList();//HOTEL PANELS MANAGMENTS
	}

	public void setUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		signInBtn.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(signInBtn);
		
		signUpBtn.setBounds(335, 45, 89, 23);
		frame.getContentPane().add(signUpBtn);
		
		wellcome.setBounds(345, 100, 100, 100);
		frame.getContentPane().add(wellcome);
	//SIGN UP
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp t = new SignUp(customers, hotelDB);
				t.signUpForm(customers, hotelDB);
			}
		});
	//SIGN IN
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn t = new SignIn(customers, wellcome, user, hotelDB);
				t.signInForm(customers, wellcome, user, hotelDB);
			}
		});
	//ON CLOSE
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				hotelDB.saveData();
				customers.setData();
				prevDate.saveCurDate();
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
		JPanel[] panels = new JPanel[counter];//HOTEL COUNTER
		JLabel[] lbs = new JLabel[counter];
		JButton[] btns = new JButton[counter];
		for(i = 0; i < counter; i++) {//change to hotelDB
			panels[i] = new JPanel();
			btns[i] = new JButton("Order now!");
			lbs[i]=new JLabel(hotelDB.hotels.get(i).toString());//hotel name
			
		    btns[i].addActionListener(listener);
		    btns[i].setName(String.valueOf(i));
		    
		    lbs[i].setPreferredSize(new Dimension(200, 50));
		    btns[i].setPreferredSize(new Dimension(150, 30));
		    
		    panels[i].setBounds(10, i*(110 + 10) + 10, 250, 110);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));

			panels[i].add(lbs[i]);
			panels[i].add(btns[i]);
			frame.getContentPane().add(panels[i]);
		}
	}
}
