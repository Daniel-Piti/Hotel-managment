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
	
	public void placeOrderDates(Date d, int roomTypeIndex, long nights) {
		Date dt = d;
		Calendar c = Calendar.getInstance(); 
		for(int i = 0; i < nights; i++) {
			if(calender.containsKey(dt))
				calender.put(dt, calender.get(dt) + 1);
			else
				calender.put(dt, 1);

			System.out.println("place on - " + dt);
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
		}
	}
}
