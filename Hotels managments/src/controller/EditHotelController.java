package controller;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.EditHotelModel;
import model.Hotel;

public class EditHotelController {
	public EditHotelModel editHotelModel;
	
	public EditHotelController(Hotel h) {
		editHotelModel = new EditHotelModel(h);
	}

	public void loadAddRoomType(JComboBox<String> roomTypes, int darkFlag) {
		editHotelModel.runAddRoomType(roomTypes, darkFlag);
	}

	public void loadFields(JTextField nameField, JTextField addressField, JTextField phoneField,
			JPasswordField passwordField) {
		editHotelModel.loadFields(nameField, addressField, phoneField, passwordField);
	}
	
	
	
}
