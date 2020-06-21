package controller;

import javax.swing.JLabel;

import model.Customer;
import model.HotelRepo;
import model.SignUpModel;
import model.UsersRepo;
import model.Validation;

public class SignUpController {
	SignUpModel signUpModel;
	
	public SignUpController(UsersRepo customers, HotelRepo hotelDB, Customer user) {
		signUpModel = new SignUpModel(customers, hotelDB, user);
	}
	public void addUser(Customer customer) {
		signUpModel.addUser(customer);
	}
	
	public boolean validUser(String firstName, JLabel firstNameLabel, String lastName,
			JLabel lastNameLabel, String phone, JLabel phoneNumberLabel, String mail,
			JLabel mailLabel, String id, JLabel idLabel, char[] password, JLabel passwordLabel,
			int day, int month, int year, JLabel dateLabel) {
		
		boolean flag = true;
		Validation v = new Validation();
		
		//check first
		if(!v.validName(firstName, firstNameLabel))
			flag = false;
//check lastname
		if(!v.validName(lastName, lastNameLabel))
			flag = false;
									
//check phonenumber
		if(!v.validPhone(phone, phoneNumberLabel))
			flag = false;
//check mail
		if(!v.validEmail(mail, mailLabel))
			flag = false;
		
		if(signUpModel.unusedMail(mail, mailLabel) == false)
			flag = false;
//check ID
		if(!v.validID(id, idLabel))
			flag = false;
//check Password
		if(!v.validPassword(password, passwordLabel))
			flag = false;
//check date
		if(!v.validDate(day, month, year, dateLabel))
			flag = false;
		
		return flag;
	}

	public void SetUser(String firstName, String lastName, String phone, String mail,
			String id, boolean gen, String password, int day, int month, int year) {
		signUpModel.setUser(firstName, lastName, phone, mail, id, gen, password,
				day, month, 2021 - year);
		
	}
}
