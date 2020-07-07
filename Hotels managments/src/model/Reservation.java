package model;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public String hotelName;
	public String roomTypeName;
    public int nights;
	public double totalPrice;
	public Date startDate;
	
	public Reservation(String hotelName, String roomTypeName, int nights, double totalPrice, Date startDate){
		this.hotelName = hotelName;
		this.roomTypeName = roomTypeName;
		this.nights = nights;
		this.totalPrice = totalPrice;
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "<html>Hotel name: " + hotelName + "<br>Room Type: " + roomTypeName + "<br>Total price: " + totalPrice +"<br>" + nights + " nights.</html>";
	}
}
