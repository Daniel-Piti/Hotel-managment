package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyOrdersModel {

	private Customer user;
	
	public MyOrdersModel(Customer user) {
		this.user = user;
		System.out.println(user.reservations.size());
	}
	
	public void fixResrv() {
		for(int i = 0; i < user.reservations.size(); i++)
			if(user.reservations.get(i).hotelName == null)
				user.reservations.remove(i--);
	}
	

	public void setHotelList(JFrame frame, ArrayList<JLabel> labels, ArrayList<JPanel> panels, ArrayList<JButton> btns) {
		ActionListener listener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				System.out.println(user.reservations.size());		
				int i, j;
				if (e.getSource() instanceof JButton) {
					int index = Integer.parseInt(((JButton) e.getSource()).getName());
					panels.get(index).setVisible(false);
					HotelRepo hotelDB = HotelRepo.getInstance();
					for(i = 0; i < hotelDB.hotels.size(); i++) {											//EVERY HOTEL
						if(hotelDB.hotels.get(i).getName().equals(user.reservations.get(index).hotelName)) //WHEN HOTEL MATCHS
							for(j = 0; j < hotelDB.hotels.get(i).roomTypes.size(); j++)					//ROOM TYPES
								if(hotelDB.hotels.get(i).roomTypes.get(j).typeName.equals(user.reservations.get(index).roomTypeName)) {
									hotelDB.hotels.get(i).roomTypes.get(j).cancleOrder(user.reservations.get(index).startDate ,user.reservations.get(index).nights);
									user.reservations.get(index).hotelName = null;
									break;
								}
					}
		        }
			}
		};
		
		int i, counter = user.getReservation().size();
		boolean f = true;
		if(counter > 0) {
			System.out.println(counter);
			JPanel[] p = new JPanel[counter];//HOTEL COUNTER
			JButton[] b = new JButton[counter];
			JLabel[] lbs = new JLabel[counter];
			for(i = 0; i < counter; i++) {//change to hotelDB
			//Create data on panel
				p[i] = new JPanel();
				b[i] = new JButton("Delete");
				lbs[i] =new JLabel(user.getReservation().get(i).toString());
			//Set size
			    lbs[i].setPreferredSize(new Dimension(130, 100));
			//Add event & index
			    b[i].addActionListener(listener);
			    b[i].setName(String.valueOf(i));
			   //Set location
			    if(f)
			    	p[i].setBounds(10, i*90 + 10, 170, 160);
			    else
			    	p[i].setBounds(200, (i - 1)*90 +10, 170, 160);
			    f = !f;
			    b[i].setPreferredSize(new Dimension(150, 30));

				p[i].setBorder(BorderFactory.createLineBorder(Color.black));
			//Add items 2 panel & frame
				p[i].add(lbs[i]);
				p[i].add(b[i]);
				
				btns.add(b[i]);
				labels.add(lbs[i]);
				panels.add(p[i]);
				frame.getContentPane().add(p[i]);
			}
			if(i == 1)
				frame.setBounds(100,100,250,250);
			else
				frame.setBounds(100, 100, 450, i*100 + 100);
		}else {
			JLabel t = new JLabel("Empty");
			t.setBounds(200, 80, 100, 100);
			frame.getContentPane().add(t);
		}
	}
}
