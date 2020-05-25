package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HotelRepo {

	private String filename;
	public List<Hotel> hotels;
	
	public HotelRepo(String filename) {
		this.filename = filename;
		hotels = null;
		loadData();
		//saveData();
	}
	
	public void fixHotelsDates(int diff) {
		if(diff > 0)
			for(int i = 0; i < hotels.size(); i++) {
				for(int j = 0; j < hotels.get(i).roomTypes.size(); j++)
					for(int k = 0; k < diff; k++) {
						hotels.get(i).roomTypes.get(j).calender.remove(0);
						hotels.get(i).roomTypes.get(j).calender.add(hotels.get(i).roomTypes.get(j).amount);
					}
			}
	}
	
	public void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			hotels = (List<Hotel>) in.readObject();
			for(Hotel h : hotels) {
				System.out.println(h.toString());
				System.out.println(h.getName() + " got " + h.roomTypes.size() + " roomtypes.");
			}
			System.out.println("HOTEL DATA LOADED");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean emailUsed(String email) {
		for(int i = 0; i < hotels.size(); i++)
			if(email.equals(hotels.get(i).getMail()))
				return true;
		return false;
	}
	
	public Hotel find(String email) {
		for(int i = 0; i < hotels.size(); i++)
			if(email.equals(hotels.get(i).getMail()))
				return hotels.get(i);
		return null;
	}
	
	public void addHotel(Hotel h) {
		hotels.add(h);
		System.out.println("HOTEL ADDED");
		saveData();
	}
	
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			//FOR RESETS
//			hotels = new ArrayList<Hotel>();
//			
//			hotels.add(new Hotel("#hotelName", "#address", "#phoneNumber", "#pass", "#mail", 5));
//			
//			hotels.get(0).addRoomType("one", 2, 2, 2, 2);

			out.writeObject(hotels);
			System.out.println("HOTELS DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
