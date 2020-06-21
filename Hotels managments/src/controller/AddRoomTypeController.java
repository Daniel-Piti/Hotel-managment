package controller;

import javax.swing.JLabel;

import model.AddRoomTypeModel;
import model.Hotel;
import model.Validation;

public class AddRoomTypeController {
	AddRoomTypeModel addRoomModel;
	
	public AddRoomTypeController(Hotel hotel) {
		addRoomModel = new AddRoomTypeModel(hotel);
	}
	
	public void addRoom(String name, int capacity, double price, double size, int amount) {
		addRoomModel.loadRoom(name , capacity, price, size, amount);
	}
	
	public boolean validInput(String name, String capacity,String price, String size, String amount, JLabel typeNameError, JLabel capacityError, JLabel priceError, JLabel sizeError, JLabel amountError) {
		Validation v = new Validation();
		boolean flag = true;
	//typeName
		if(!v.validNotEmpty(name, typeNameError))
			flag = false;
	//capacity
		if(!v.validNumber(capacity, capacityError))
			flag = false;
	//price
		if(!v.validDouble(price, priceError))
			flag = false;
	//size
		if(!v.validDouble(size, sizeError))
			flag = false;
	//amount
		if(!v.validNumber(amount, amountError))
			flag = false;
		return flag;
	}
}
