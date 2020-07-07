package model;

import java.util.Date;

import javax.swing.JComboBox;

public class OrderModel {
	public Hotel hotel;
	private Customer user;
	private UsersRepo customers;
	
	public OrderModel(Hotel hotel, Customer user, UsersRepo customers) {
		this.hotel = hotel;
		this.user = user;
		this.customers = customers;
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

	public void addReservation(int index, int diff, Date startDate) {
		customers.find(user.email).addReservasion(hotel.getName(), hotel.roomTypes.get(index).typeName, diff, hotel.roomTypes.get(index).price * diff, startDate);
		System.out.println("YYYYYYYY!!!!!");
	}
}
