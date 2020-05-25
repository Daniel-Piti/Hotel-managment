package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyDate implements Serializable {
	public int day;
	public int month;
	public int year;
	
	public MyDate(int d,int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	@Override
	public String toString() {
		return String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);
	}

	public int getDaysDiff(MyDate d) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		try {
		//PREV
		    Date date1 = myFormat.parse(this.day + " " + this.month + " " + this.year);
		//NOW
		    Date date2 = myFormat.parse(d.day + " " + d.month + " " + d.year);
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days diff: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		    return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return -1;
	}
	
	public void loadPrevDate() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Hotels/date.txt"))){
			MyDate temp = (MyDate) in.readObject();
			System.out.println("Prev date's Data loaded! - " + temp.toString());
			this.day = temp.day;
			this.month = temp.month;
			this.year = temp.year;
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveCurDate() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Hotels/date.txt"))){
		//FOR RESETS 
			LocalDateTime now = LocalDateTime.now();
			MyDate t = new MyDate(now.getDayOfMonth() - 2, now.getMonthValue(), now.getYear());

			out.writeObject(t);
			System.out.println("Now time DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
