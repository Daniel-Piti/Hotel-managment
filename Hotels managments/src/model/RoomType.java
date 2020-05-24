package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomType implements Serializable {
	public int capacity;
	public double price;
	public boolean smoking;
	public double size;
	public int amount;
	public List<Integer> calender;
	
	public RoomType(int capacity, double price, boolean smoking, double size, int amount) {
		this.capacity = capacity;
		this.price = price;
		this.smoking = smoking;
		this.size = size;
		this.amount = amount;
		calender = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++)//7 -> week
			calender.add(amount);
	}
}
