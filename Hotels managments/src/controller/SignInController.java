package controller;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Customer;
import model.HotelRepo;
import model.SignInModel;
import model.UsersRepo;

public class SignInController {
	SignInModel signInModel;
	
	public SignInController(JLabel wellcome, Customer user, UsersRepo users, HotelRepo hotels,JButton in, JButton up, JButton dis, int dark, JButton myOrders) {
		signInModel = new SignInModel(wellcome, user, users, hotels, in, up, dis, dark, myOrders);
	}

	public boolean checkProjManaget(String mail, String pass) {
		if(mail.equals("alpha") && pass.equals("alpha")) {
			signInModel.runAddHotel();
			return true;
		}
		return false;
	}
	
	public boolean checkHotels(String mail, String pass) {
		return signInModel.checkEditHotel(mail, pass);
	}

	public boolean checkUsers(String mail, String pass) {
		return signInModel.validUser(mail, pass);
	}
	
	
	
}
