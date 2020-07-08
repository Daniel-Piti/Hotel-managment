package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	protected ArrayList<Reservation> reservations;
	
	public ArrayList<Reservation> getReservation() {
		return reservations;
	}
	
	public void addReservasion(String hotelName, String roomTypeName, int nights, double totalPrice, Date startDate) {
		reservations.add(new Reservation(hotelName, roomTypeName, nights, totalPrice, startDate));
	}
	
	public Customer(String firstName, String lastName, String phoneNumber,
			String mail, String ID, boolean gender,
			String password, int d, int m, int y) {
		super(Person.Builder.newInstance()
				.withFirstname(firstName)
				.withLastName(lastName)
				.withPhone(phoneNumber)
				.withMail(mail)
				.withPublicID(ID)
				.withGender(gender)
				.withPassword(password)
				.withBday(new MyDate(d, m, y))
				);
		this.reservations = new ArrayList<Reservation>();
	}

	@Override
	public String toString() {
		return "customer [" + firstName + ' ' + lastName + ' '+ phoneNumber + ' ' + email + ' ' +
				publicID + ' ' + gender + ' ' + password + ' ' + bday.day +' '+ 
				bday.month + ' ' + bday.year + "]";
	}
}