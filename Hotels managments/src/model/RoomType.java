package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomType implements Serializable {
	public String typeName;
	public int capacity;
	public double price;
	public double size;
	public int amount;
	public List<Integer> calender;
	
	public RoomType(String typeName, int capacity, double price, double size, int amount) {
		this.typeName = typeName;
		this.capacity = capacity;
		this.price = price;
		this.size = size;
		this.amount = amount;
		calender = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++)//7 -> week
			calender.add(amount);
	}
}
