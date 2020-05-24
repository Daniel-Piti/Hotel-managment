package model;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
	
	public Customer(String firstName, String lastName, String phoneNumber,
			String mail, String ID, boolean gender,
			String password, int d, int m, int y) {
			super(firstName, lastName,phoneNumber,mail,ID,gender,password,d,m,y);
	}
	
	
	
	public Customer(Customer temp) {
		super(temp.getFirstName(), temp.getLastName(), temp.getPhone(), temp.getEmail(), temp.getID(), temp.getGender(), temp.getPass(), temp.getDay(), temp.getMonth(), temp.getYear());
	}

	@Override
	public String toString() {
		return firstName + ' ' + lastName + ' '+ phoneNumber + ' ' + email + ' ' +
				publicID + ' ' + gender + ' ' + password + ' ' + bday.day +' '+ 
				bday.month + ' ' + bday.year;
	}
}