package controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.AddHotelModel;
import model.Validation;

public class AddHotelController {
	AddHotelModel addHotelModel;
	
	public AddHotelController() {
		addHotelModel = new AddHotelModel();
	}
	
	public void loadHotelList(JComboBox<String> temp) {
		addHotelModel.loadHotelList(temp);
	}
	
	public boolean validHotel(String name, String address, String phone, char[] password, String mail, JLabel nameError,
			JLabel addressError, JLabel phoneError, JLabel passwordError, JLabel mailError, int stars, String managerHotel) {
		boolean flag = true;
		Validation v = new Validation();
		if(!v.validNotEmpty(name, nameError))
			flag = false;
		
		if(!v.validNotEmpty(address, addressError))
			flag = false;
		
		if(!v.validPhone(phone, phoneError))
			flag = false;
		
		if(!v.validPassword(password, passwordError))
			flag = false;
		
		if(!v.validEmail(mail, mailError))
			flag = false;
		
		if(flag == true)
			flag = addHotelModel.checkDB(name, address, phone, password, mail, mailError, stars, managerHotel);
		return flag;
	}

	public void removeHotel(int index) {
			addHotelModel.removeHotel(index);
	}
	
	
}
