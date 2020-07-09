 package model;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.AddHotel;
import view.EditHotel;

public class SignInModel {
	private Customer user;
	private UsersRepo customers;
	private HotelRepo hotelDB;
	private JButton inBtn;
	private JButton upBtn;
	private JButton editDetails;
	private JButton disBtn;
	private JButton myOrders;
	private JLabel wellcome;
	
	public SignInModel(JLabel wellcome, Customer user, JButton in, JButton up, JButton dis, JButton myOrders, JButton editDetails) {
		this.wellcome = wellcome;
		this.user = user;
		this.customers = UsersRepo.getInstance();
		this.hotelDB = HotelRepo.getInstance();
		this.inBtn = in;
		this.upBtn = up;
		this.disBtn = dis;
		this.myOrders = myOrders;
		this.editDetails = editDetails;
	}
	
	public void runAddHotel() {
		AddHotel addHotel = new AddHotel();
		addHotel.RunAddHotel();
		inBtn.setVisible(false);
		upBtn.setVisible(false);
		wellcome.setText("<html>Hello Project<br>manager!<html>");
	}
	
	public boolean checkEditHotel(String mail, String pass) {
		Hotel ho = hotelDB.find(mail);
		if(ho != null && ho.hotelManager.password.equals(pass)) {
			EditHotel editHotel = new EditHotel(ho);
			editHotel.runEditHotel(ho);
			inBtn.setVisible(false);
			upBtn.setVisible(false);
			disBtn.setVisible(true);
			wellcome.setText("<html>Hello " + ho.getName() + "<br>hotel manager!<html>");
			return true;
		}
		return false;
	}
	public boolean validUser(String mail, String pass) {
		Customer c = customers.find(mail);
		if(c == null || !c.getPass().equals(String.valueOf(pass))) 
			return false;
		inBtn.setVisible(false);
		upBtn.setVisible(false);
		disBtn.setVisible(true);
		myOrders.setVisible(true);
		editDetails.setVisible(true);
		user.duplicate(c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail(), c.getID(), true, c.getPass(), 0, 0, 0);
		wellcome.setText("<html>Hello<br>" + c.getFirstName()+ "!<html>");
		return true;
	}
}
