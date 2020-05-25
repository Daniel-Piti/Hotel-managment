package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
	private String hotelName;
	private String address;
	private String phoneNumber;
	private String password;
	private String mail;
	private int stars;
	public List<RoomType> roomTypes;
	
	public Hotel(String hotelName, String address, String phoneNumber, String password, String mail, int stars) {
		this.hotelName = hotelName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.mail = mail;
		this.stars = stars;
		this.roomTypes = new ArrayList<RoomType>();
	}
	
	public void addRoomType(String typeName, int capacity, double price, double size, int amount) {
		roomTypes.add(new RoomType(typeName ,capacity, price, size, amount));
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getName() {
		return hotelName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void editHotel(String hotelName, String address, String phone, String pass) {
		this.hotelName = hotelName;
		this.address = address;
		this.phoneNumber = phone;
		this.password = pass;
	}
	
	@Override
	public String toString() {
		return "<html>The " + hotelName + " hotel got " + String.valueOf(stars) + " stars.<br>The address is " + address + ".<br>And the phone is " + phoneNumber + ".<html>";
	}
}
