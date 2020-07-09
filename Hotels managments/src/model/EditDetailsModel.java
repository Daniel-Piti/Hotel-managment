package model;

import javax.swing.JTextField;

public class EditDetailsModel {
	Customer user;
	UsersRepo users = UsersRepo.getInstance();
	
	public EditDetailsModel(Customer user) {
		this.user = user;
	}

	public void updateDetails(String first, String last, String phone, String pass) {
		users.find(user.getEmail()).duplicate(first, last, phone, user.getEmail(), user.getID(), user.getGender(), pass, user.getDay(), user.getMonth(), user.getYear());
	}

	public void loadFields(JTextField firstnameField, JTextField lastnameField, JTextField phoneField,	JTextField passField) {
		firstnameField.setText(user.getFirstName());
		lastnameField.setText(user.getLastName());
		phoneField.setText(user.getPhone());
		passField.setText(user.getPass());
	}
}
