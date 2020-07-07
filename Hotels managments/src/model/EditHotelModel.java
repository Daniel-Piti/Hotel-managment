
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
	
	public void runAddRoomType(JComboBox<String> roomTypes) {
		AddRoomType a = new AddRoomType(hotel, roomTypes);
		a.RunAddRoom(hotel, roomTypes);
	}

	public void loadFields(JTextField nameField, JTextField addressField, JTextField phoneField,
			JPasswordField passwordField) {
		nameField.setText(hotel.getName());
		addressField.setText(hotel.getAddress());
		phoneField.setText(hotel.getPhone());
	}
	
	public void deleteRoom(int index) {
		hotel.roomTypes.remove(index);
	}
	
}
