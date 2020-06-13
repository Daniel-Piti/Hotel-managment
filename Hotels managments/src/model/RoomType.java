package model;

import java.io.Serializable;
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
}
