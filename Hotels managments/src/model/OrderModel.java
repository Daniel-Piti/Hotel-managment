package model;

import java.util.Date;

import javax.swing.JComboBox;

public class OrderModel {
	public Hotel hotel;
	private Customer user;
	
	public OrderModel(Hotel hotel, Customer user) {
		this.hotel = hotel;
		this.user = user;
	}

	public void loadRooms(JComboBox<String> roomTypeCombo) {
		for(int i = 0; i < hotel.roomTypes.size(); i++)
			roomTypeCombo.addItem(hotel.roomTypes.get(i).typeName);	
	}
	
	public int checkRoomTypesSize() {
		return hotel.roomTypes.size();
	}

	public boolean checkAvalible(Date startDate, int index, long diff) {
		return hotel.roomTypes.get(index).checkAvailable(startDate, index, diff);
	}
	
	public void addOrder(int index, Date startDate, int diff) { 
		hotel.roomTypes.get(index).placeOrderDates(startDate, diff);
		System.out.println(user.getFirstName());
	}
}
