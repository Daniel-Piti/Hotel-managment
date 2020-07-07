package model;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AddHotelModel {
	private HotelRepo hotelsDB;
	private UsersRepo users;
	
	public AddHotelModel() {
		this.hotelsDB = HotelRepo.getInstance();
		this.users = UsersRepo.getInstance();
	}
	
	public void loadHotelList(JComboBox<String> temp) {
		for(int i=0;i<hotelsDB.hotels.size();i++)
			temp.addItem(hotelsDB.hotels.get(i).getName());
	}
	
	public boolean checkDB(String name, String address, String phone, char[] password, String mail, JLabel mailError, int stars, String managerMail) {
//users db
		if(users.emailUsed(mail) || hotelsDB.emailUsed(mail)) {
			mailError.setText("Email allready used");
			return false;
		}
		hotelsDB.addHotel(new Hotel(name, address, phone, String.valueOf(password), mail, stars, managerMail));
		return true;
	}
	
	public void removeHotel(int index) {
		hotelsDB.hotels.remove(index);
	}
}
