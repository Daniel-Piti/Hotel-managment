package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.EditDetails;
import view.MyOrders;
import view.Order;
import view.SignInView;
import view.SignUp;

public class MainModel {
//CUSTOMER DB
	private UsersRepo customers;
// LOGED USER
	private Customer user;
//HOTELS REPO
	private HotelRepo hotelDB;
	
	public MainModel() {
		user = new Customer(null, null, null, null, null, false, null, 0, 0, 0);
		customers = UsersRepo.getInstance();
		hotelDB =HotelRepo.getInstance();
		fixDays();
		System.out.println("all data is set");
	}
	
	private void fixDays() {
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
	
	public void runSignIn(JLabel wellcome, JButton in, JButton up, JButton dis, JButton myOrders, JButton editDetails) {
		SignInView signIn = new SignInView(wellcome, user, in, up, dis, myOrders, editDetails);
		signIn.runSignIn(wellcome, user, in, up, dis, myOrders, myOrders, editDetails);
	}

	public void setHotelList(JFrame frame, ArrayList<JButton> btns, ArrayList<JLabel> labels, ArrayList<JPanel> panels) {
		ActionListener listener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					if(user.getEmail() == null)
						JOptionPane.showMessageDialog(null,"Sign in as a customer to order!"); // CREATES MASSAGE
					else {
						int index = Integer.parseInt(((JButton) e.getSource()).getName());
						Order order = new Order(hotelDB.hotels.get(index), user);
		           		order.runOrder(hotelDB.hotels.get(index), user);
					}
		        }
			}
		};
		int i, counter = hotelDB.hotels.size();
		JPanel[] p = new JPanel[counter];//HOTEL COUNTER
		JLabel[] lbs = new JLabel[counter];
		JButton[] b = new JButton[counter];
		for(i = 0; i < counter; i++) {//change to hotelDB
		//Create data on panel
			p[i] = new JPanel();
			b[i] = new JButton("Order now!");
			lbs[i]=new JLabel(hotelDB.hotels.get(i).toString());//hotel name
		//Add event & index
		    b[i].addActionListener(listener);
		    b[i].setName(String.valueOf(i));
		//Set size
		    lbs[i].setPreferredSize(new Dimension(200, 80));
		    b[i].setPreferredSize(new Dimension(150, 30));
		//Set location
		    p[i].setBounds(10, i*(140 + 10) + 10, 280, 140);
			p[i].setBorder(BorderFactory.createLineBorder(Color.black));
		//Add items 2 panel & frame
			p[i].add(lbs[i]);
			p[i].add(b[i]);
			
			btns.add(b[i]);
			labels.add(lbs[i]);
			panels.add(p[i]);
			frame.getContentPane().add(p[i]);
		}
	}

	public void saveData() {
		hotelDB.saveData();
		customers.saveData();
	}

	public void resetUser() {
		user.duplicate(null, null, null, null, null, false, null, 0, 0, 0);
	}

	public void runSignUp(JLabel wellcome, JButton signInBtn, JButton signUpBtn, JButton disconnectBtn, JButton myOrders, JButton editDetails) {
		SignUp signUp = new SignUp(wellcome, signInBtn, signUpBtn, disconnectBtn, user, myOrders, editDetails);
		signUp.runSignUp(wellcome, signInBtn, signUpBtn, disconnectBtn, user, myOrders, editDetails);
	}

	public void runMyOrders() {
		MyOrders myOrders = new MyOrders(user);
		myOrders.runMyOrders(customers.find(user.email));
	}

	public void runEditDetails() {
		EditDetails editHotels = new EditDetails(user);
		editHotels.runEditDetails(user);
	}
}
