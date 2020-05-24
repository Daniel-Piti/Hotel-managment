package model;

import java.util.List;

public class Hotel {
	private int managerID;
	private String hotelName;
	private String address;
	private int stars;
	private List<RoomType> roomTypes;
	private String phoneNumber;
	
	
	
	public Hotel(int managerID, String hotelName, String address, int stars, String phoneNumber) {
		this.managerID = managerID;
		this.hotelName = hotelName;
		this.address = address;
		this.stars = stars;
		this.phoneNumber = phoneNumber;
		this.roomTypes = null;
	}
	
	public void addRoomType(int capacity, double price, boolean smoking, double size) {
		RoomType t = new RoomType(capacity, price, smoking, size);
		roomTypes.add(t);
	}
	
	@Override
	public String toString() {
		return "The hotel " + hotelName + " got " + String.valueOf(stars) + ".\nThe address is " + address + ".\nAnd the phone is " + phoneNumber + ".";
	}
}
