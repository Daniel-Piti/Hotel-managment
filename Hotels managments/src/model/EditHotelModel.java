
package model;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.AddRoomType;

public class EditHotelModel {
	public Hotel hotel;
	
	public EditHotelModel(Hotel h) {
		this.hotel = h;
	}
	
	public void runAddRoomType(JComboBox<String> roomTypes) {
		AddRoomType a = new AddRoomType(hotel, roomTypes);
		a.RunAddRoom(hotel, roomTypes);
	}

	public void loadFields(JTextField nameField, JTextField addressField, JTextField phoneField) {
		nameField.setText(hotel.getName());
		addressField.setText(hotel.getAddress());
		phoneField.setText(hotel.getPhone());
	}
	
	public void deleteRoom(int index) {
		hotel.roomTypes.remove(index);
	}

	public void setTotalIncome(JLabel totalIncome) {
		totalIncome.setText(String.valueOf(hotel.getTotal()) + "$");
	}
	
}
