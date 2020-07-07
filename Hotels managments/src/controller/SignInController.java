package controller;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Customer;
import model.SignInModel;

public class SignInController {
	SignInModel signInModel;
	
	public SignInController(JLabel wellcome, Customer user, JButton in, JButton up, JButton dis, JButton myOrders) {
		signInModel = new SignInModel(wellcome, user, in, up, dis, myOrders);
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
