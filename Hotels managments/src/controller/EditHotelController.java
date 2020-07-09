package controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.EditHotelModel;
import model.Hotel;

public class EditHotelController {
	public EditHotelModel editHotelModel;
	
	public EditHotelController(Hotel h) {
		editHotelModel = new EditHotelModel(h);
	}

	public void loadAddRoomType(JComboBox<String> roomTypes) {
		editHotelModel.runAddRoomType(roomTypes);
	}

	public void loadFields(JTextField nameField, JTextField addressField, JTextField phoneField) {
		editHotelModel.loadFields(nameField, addressField, phoneField);
	}
	
	public void removeRoom(int index) {
		editHotelModel.deleteRoom(index);
	}

	public void setTotalIncome(JLabel totalIncome) {
		editHotelModel.setTotalIncome(totalIncome);
	}
	
}
