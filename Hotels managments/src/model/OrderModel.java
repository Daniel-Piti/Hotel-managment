package model;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class OrderModel {
	public Hotel hotel;
	private Customer user;
	private UsersRepo customers;
	
	public OrderModel(Hotel hotel, Customer user) {
		this.hotel = hotel;
		this.user = user;
		this.customers = UsersRepo.getInstance();
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
		hotel.total += diff * hotel.roomTypes.get(index).price;
	}

	public void addReservation(int index, int diff, Date startDate) {
		customers.find(user.email).addReservasion(hotel.getName(), hotel.roomTypes.get(index).typeName, diff, hotel.roomTypes.get(index).price * diff, startDate);
	}

	public void setDesc(JLabel roomDesc, int selectedIndex) {
		if(hotel.roomTypes.size() > 0)
			roomDesc.setText(hotel.roomTypes.get(selectedIndex).toString());
	}
}
