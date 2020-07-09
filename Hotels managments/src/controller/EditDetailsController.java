package controller;

import javax.swing.JTextField;

import model.Customer;
import model.EditDetailsModel;

public class EditDetailsController {
	EditDetailsModel ediDetailsModel;
	
	public EditDetailsController(Customer user) {
		ediDetailsModel = new EditDetailsModel(user);
	}

	public void upDateDetails(String first, String last, String phone, String pass) {
		ediDetailsModel.updateDetails(first, last, phone, pass);
	}

	public void loadFields(JTextField firstnameField, JTextField lastnameField, JTextField phoneField,
			JTextField passField) {
		ediDetailsModel.loadFields(firstnameField, lastnameField, phoneField, passField);
	}
}
