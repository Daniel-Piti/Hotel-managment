package model;

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
	
	public String getDate() {
		return String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);
	}
}
