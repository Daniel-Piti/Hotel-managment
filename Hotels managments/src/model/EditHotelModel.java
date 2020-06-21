
package model;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.AddRoomType;

public class EditHotelModel {
	public Hotel hotel;
	
	public EditHotelModel(Hotel h) {
		this.hotel = h;
	}

	public void loadFields() {
		
	}
	
	public void runAddRoomType(JComboBox<String> roomTypes, int darkFlag) {
		AddRoomType a = new AddRoomType(hotel, roomTypes, darkFlag);
		a.RunAddRoom(hotel, roomTypes, darkFlag);
	}

	public void loadFields(JTextField nameField, JTextField addressField, JTextField phoneField,
			JPasswordField passwordField) {
		nameField.setText(hotel.getName());
		addressField.setText(hotel.getAddress());
		phoneField.setText(hotel.getPhone());
		passwordField.setText(hotel.getPassword());
	}
}
