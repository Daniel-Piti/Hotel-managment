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
	private JButton disBtn;
	private JLabel wellcome;
	private int darkFlag;
	
	public SignInModel(JLabel wellcome, Customer user, UsersRepo users, HotelRepo hotels,JButton in, JButton up, JButton dis, int dark) {
		this.wellcome = wellcome;
		this.user = user;
		customers = users;
		hotelDB = hotels;
		inBtn = in;
		upBtn = up;
		disBtn = dis;
		darkFlag = dark;
	}
	public void runAddHotel() {
		AddHotel addHotel = new AddHotel(hotelDB, customers, darkFlag);
		addHotel.RunAddHotel(hotelDB, customers, darkFlag);
		user.duplicate("Project", "manager", null, null, null, true, null, 0, 0, 0);
		inBtn.setVisible(false);
		upBtn.setVisible(false);
		disBtn.setVisible(true);
		wellcome.setText("<html>Hello Project<br>manager!<html>");
	}
	
	public boolean checkEditHotel(String mail, String pass) {
		Hotel ho = hotelDB.find(mail);
		if(ho != null && ho.getPassword().equals(pass)) {
			EditHotel editHotel = new EditHotel(ho, darkFlag);
			editHotel.runEditHotel(ho, darkFlag);
			inBtn.setVisible(false);
			upBtn.setVisible(false);
			disBtn.setVisible(true);
			user.duplicate("Hotel", "manager", null, null, null, true, null, 0, 0, 0);
			wellcome.setText("<html>Hello" + ho.getName() + "<br>hotel manager!<html>");
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
		user.duplicate("Hotel", "manager", null, null, null, true, null, 0, 0, 0);
		wellcome.setText("<html>Hello<br>" + c.getFirstName()+ "!<html>");
		return true;
	}
}
