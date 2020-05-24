package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
	private int managerID;
	private String hotelName;
	private String address;
	private int stars;
	private String phoneNumber;
	public List<RoomType> roomTypes;
	
	public Hotel(int managerID, String hotelName, String address, int stars, String phoneNumber) {
		this.managerID = managerID;
		this.hotelName = hotelName;
		this.address = address;
		this.stars = stars;
		this.phoneNumber = phoneNumber;
		this.roomTypes = new ArrayList<RoomType>();
		//minimum price?
	}
	
	public void addRoomType(int capacity, double price, boolean smoking, double size, int amount) {
		roomTypes.add(new RoomType(capacity, price, smoking, size, amount));
	}
	
	@Override
	public String toString() {
		return "<html>The " + hotelName + " hotel got " + String.valueOf(stars) + " stars.<br>The address is " + address + ".<br>And the phone is " + phoneNumber + ".<html>";
	}
}
