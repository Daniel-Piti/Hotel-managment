package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	
	protected  String firstName;
	protected String lastName;
	protected String phoneNumber;
	protected String email;
	protected String publicID;
	protected String password;
	protected Date bday;
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
		bday = new Date(d, m, y);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void n() {}
	
	public String getEmail() {
		return email;
	}
	
	public void updateProfile(String phoneNumber, String email, String password) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
}