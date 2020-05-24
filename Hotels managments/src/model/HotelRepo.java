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
	
	public void printrooms() {
		for(int i = 0; i < hotels.size(); i++)
			System.out.println(hotels.get(i).roomTypes.size());
	}
	
	public void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			hotels = (List<Hotel>) in.readObject();
			for(Hotel h : hotels) {
				System.out.println(h.toString());
			}
			System.out.println(filename + "'s Data loaded!");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addHotel(Hotel h) {
		hotels.add(h);
		System.out.println("added hotel");
		saveData();
	}
	
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			//FOR RESETS
//			hotels = new ArrayList<Hotel>();
//			hotels.add(new Hotel(1, "panorama", "hahistadrut 88", 5, "0505566979"));
//			hotels.add(new Hotel(2, "dan", "tel aviv", 5, "0503333976"));
//			hotels.get(0).addRoomType(2, 200, true, 30, 10);
//			hotels.get(0).addRoomType(2, 200, true, 30, 10);
//			hotels.get(1).addRoomType(2, 200, true, 30, 10);
			out.writeObject(hotels);
			System.out.println(filename + "'s DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
