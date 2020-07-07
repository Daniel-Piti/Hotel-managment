package model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyOrdersModel {

	private Customer user;
	
	public MyOrdersModel(Customer user) {
		this.user = user;
	}
	
	public void setHotelList(JFrame frame, ArrayList<JLabel> labels, ArrayList<JPanel> panels) {
		int i, counter = user.getReservation().size();
		if(counter > 0) {
			System.out.println(counter);
			JPanel[] p = new JPanel[counter];//HOTEL COUNTER
			JLabel[] lbs = new JLabel[counter];
			for(i = 0; i < counter; i++) {//change to hotelDB
			//Create data on panel
				p[i] = new JPanel();
				lbs[i]=new JLabel(user.getReservation().get(i).toString());
			//Set size
			    lbs[i].setPreferredSize(new Dimension(380, 40));
			//Set location
			    p[i].setBounds(10, i*(50 + 10) + 10, 415, 50);
				p[i].setBorder(BorderFactory.createLineBorder(Color.black));
			//Add items 2 panel & frame
				p[i].add(lbs[i]);
				
				labels.add(lbs[i]);
				panels.add(p[i]);
				frame.getContentPane().add(p[i]);
			}
			
			frame.setBounds(100, 100, 450, i*60 + 100);
		}else {
			JLabel t = new JLabel("Empty");
			t.setBounds(200, 80, 100, 100);
			frame.getContentPane().add(t);
		}
	}
}
