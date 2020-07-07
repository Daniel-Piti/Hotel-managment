package model;

import java.io.Serializable;
import java.util.Date;

public class Customer extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Customer(String firstName, String lastName, String phoneNumber,
			String mail, String ID, boolean gender,
			String password, int d, int m, int y) {
			super(firstName, lastName,phoneNumber,mail,ID,gender,password,d,m,y);
	}
	
	
	public Customer(Customer temp) {
		super(temp.getFirstName(), temp.getLastName(), temp.getPhone(), temp.getEmail(), temp.getID(), temp.getGender(), temp.getPass(), temp.getDay(), temp.getMonth(), temp.getYear());
	}
	
	public void addReservasion(String hotelName, String roomTypeName, int nights, double totalPrice, Date startDate) {
		reservations.add(new Reservation(hotelName, roomTypeName, nights, totalPrice, startDate));
	}

	@Override
	public String toString() {
		return "customer [" + firstName + ' ' + lastName + ' '+ phoneNumber + ' ' + email + ' ' +
				publicID + ' ' + gender + ' ' + password + ' ' + bday.day +' '+ 
				bday.month + ' ' + bday.year + "]";
	}
}