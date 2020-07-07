package controller;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Customer;
import model.MyOrdersModel;

public class MyOrdersController {

	private MyOrdersModel myOrdersModel;
	
	public MyOrdersController(Customer user) {
		myOrdersModel = new MyOrdersModel(user);
	}
	
	public void setPanels(JFrame frame, ArrayList<JLabel> labels, ArrayList<JPanel> panels) {
		myOrdersModel.setHotelList(frame, labels, panels);
	}
}
