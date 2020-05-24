package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Customer;
import model.Date;
import model.HotelRepo;
import model.UsersRepo;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {
	private JFrame frame;
	JButton signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");		
	JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DE\u05D4");
//CUSTOMER DB
	public UsersRepo customers = new UsersRepo("Members/Customers.txt");
//HELLO LABEL
	public JLabel wellcome = new JLabel("Hello guest !");
// LOGED USER
	public Customer user = new Customer(null, null, null, null, null, false, null, 0, 0, 0);
//PREV DATE
	public Date prevDate = new Date(24, 5, 2020);
//HOTELS REPO
	public HotelRepo hotelDB = new HotelRepo("Hotels/hotels.txt");

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
	
	public Start() {
		setUI();
		setHotelList();//HOTEL PANELS MANAGMENTS
	}
	
	public void setUI() {
		prevDate.loadPrevDate();
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
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp t = new SignUp(customers);
				t.signUpForm(customers);
			}
		});
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn t = new SignIn(customers, wellcome, user);
				t.signInForm(customers, wellcome, user);
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
		            JOptionPane.showMessageDialog(null, hotelDB.hotels.get(index));
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
