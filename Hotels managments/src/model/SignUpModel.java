package model;

import javax.swing.JLabel;


public class SignUpModel {
	UsersRepo customers;
	HotelRepo hotelDB;
	Customer user;
	
	public SignUpModel(Customer user) {
		this.customers = UsersRepo.getInstance();
		this.hotelDB = HotelRepo.getInstance();
		this.user = user;
	}

	public boolean unusedMail(String mail, JLabel mailLabel) {
		if(customers.emailUsed(mail) || hotelDB.emailUsed(mail)) {
			mailLabel.setText("Email allready used");
			return false;
		}
		return true;
	}
	
	public void addUser(model.Customer customer) {
		customers.addUser(customer);
	}

	public void setUser(String firstName, String lastName, String phone, String mail, String id, boolean gen, String password, int day, int month, int year) {
		user.duplicate(firstName, lastName, phone, mail, id, gen, password,
				day, month, 2021 - year);
	}
}
