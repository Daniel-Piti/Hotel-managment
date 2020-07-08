package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RoomType implements Serializable {
	private static final long serialVersionUID = 1L;

	public String typeName;
	public int capacity;
	public double price;
	public double size;
	public int amount;
	public Map<Date, Integer> calender;
	
	public RoomType(String typeName, int capacity, double price, double size, int amount) {
		this.typeName = typeName;
		this.capacity = capacity;
		this.price = price;
		this.size = size;
		this.amount = amount;
		calender = new HashMap<Date, Integer>();
	}
	
	@Override
	public String toString() {
		return "<html>Name: "+ typeName + "<br>Capacity: " + capacity + "<br>price for night: " + price + "<br>Size m^2: " + size + "</html>";
	}
	
	public boolean checkAvailable(Date d, int roomTypeIndex, long nights) {
		Date dt = d;

		Calendar c = Calendar.getInstance(); 
		for(int i = 0; i < nights; i++) {
			if(calender.containsKey(dt)) 
				if(calender.get(dt) == amount) {
					System.out.println("FULL ON - " + dt);
					return false;
				}
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
		}
		return true;
	}
	
	public void cancleOrder(Date d, int nights) {
		Calendar c = Calendar.getInstance(); 
		for(int i = 0; i < nights; i++) {
			if(calender.get(d) == 1)
				calender.remove(d);
			else
				calender.put(d, calender.get(d) - 1);
			System.out.println("deleted on - " + d);
			c.setTime(d); 
			c.add(Calendar.DATE, 1);
			d = c.getTime();
		}
	}
	
	public void placeOrderDates(Date d, long nights) {
		Calendar c = Calendar.getInstance(); 
		for(int i = 0; i < nights; i++) {
			if(calender.containsKey(d))
				calender.put(d, calender.get(d) + 1);
			else
				calender.put(d, 1);

			System.out.println("place on - " + d);
			c.setTime(d); 
			c.add(Calendar.DATE, 1);
			d = c.getTime();
		}
	}
}