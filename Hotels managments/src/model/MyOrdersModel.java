package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	
	public int getDiff(Date startDate, Date endDate) {
		long diffInMillies = endDate.getTime() - startDate.getTime();
		return (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;
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
									hotelDB.hotels.get(i).total -= user.reservations.get(index).totalPrice;
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
			for(i = 0; i < counter; i++) {
				p[i] = new JPanel();
				try {
					LocalDateTime now = LocalDateTime.now();
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date cur = sdf.parse(String.valueOf(now.getMonthValue()) +'/'+String.valueOf(now.getDayOfMonth())+'/'+String.valueOf(now.getYear()));
					if(getDiff(user.reservations.get(i).startDate, cur) <= 0){
						b[i] = new JButton("Cancel");
						//Add event & index
					    b[i].addActionListener(listener);
					    b[i].setName(String.valueOf(i));
					    b[i].setPreferredSize(new Dimension(150, 30));
						p[i].add(b[i]);
						btns.add(b[i]);
					}
				} catch(Exception e) {
					System.out.println("Somthing is wrong!");
				}
			//Create data on panel
				lbs[i] =new JLabel(user.getReservation().get(i).toString());
			//Set size
			    lbs[i].setPreferredSize(new Dimension(130, 100));
			   //Set location
			    if(f)
			    	p[i].setBounds(10, i*90 + 10, 170, 160);
			    else
			    	p[i].setBounds(200, (i - 1)*90 + 10, 170, 160);
			    f = !f;

				p[i].setBorder(BorderFactory.createLineBorder(Color.black));
			//Add items 2 panel & frame
				p[i].add(lbs[i]);
				
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
			labels.add(t);
			frame.getContentPane().add(t);
		}
	}
}
