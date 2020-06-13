package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	protected  String firstName;
	protected String lastName;
	protected String phoneNumber;
	protected String email;
	protected String publicID;
	protected String password;
	protected MyDate bday;
	protected boolean gender;

	public Person(String firstName, String lastName, String phoneNumber,
			  String email, String ID, boolean gender,
			  String password, int d, int m, int y) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.publicID = ID;
		this.gender = gender;
		this.password = password;
		bday = new MyDate(d, m, y);
	}
	public void duplicate(String firstName, String lastName, String phoneNumber,
			  String email, String ID, boolean gender,
			  String password, int d, int m, int y) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.publicID = ID;
		this.gender = gender;
		this.password = password;
		this.bday.day = d;
		this.bday.month = m;
		this.bday.year = y;
	}
	
	public void setFirstname(String s) {
		this.firstName = s;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phoneNumber;
	}
	public String getID() {
		return publicID;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return password;
	}
	public boolean getGender() {
		return gender;
	}
	public int getDay() {
		return bday.day;
	}
	public int getMonth() {
		return bday.month;
	}
	public int getYear() {
		return bday.year;
	}
	
	public void updateProfile(String phoneNumber, String email, String password) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
}