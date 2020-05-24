package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Date implements Serializable {
	public int day;
	public int month;
	public int year;
	
	public Date(int d,int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	@Override
	public String toString() {
		return String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);
	}

	public void loadPrevDate() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Hotels/date.txt"))){
			Date temp = (Date) in.readObject();
			System.out.println("Prev date's Data loaded! - " + temp.toString());
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void savePrevDate() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Hotels/date.txt"))){
			//FOR RESETS
			//Date temp = new Date(day, month, year);
			//out.writeObject(temp);
			System.out.println("Prev date's DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
