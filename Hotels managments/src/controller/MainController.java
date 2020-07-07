package controller;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MainModel;

public class MainController {
	private MainModel mainModel;
	
	public MainController() {
		mainModel = new MainModel();
	}
	
	public void loadSignIn(JLabel wellcome, JButton in, JButton up, JButton dis, JButton myOrders) {
		mainModel.runSignIn(wellcome, in, up, dis, myOrders);
	}

	public void loadHotelList(JFrame frame, ArrayList<JButton> btns, ArrayList<JLabel> labels, ArrayList<JPanel> panels) {
		mainModel.setHotelList(frame, btns, labels, panels);
	}

	public void saveData() {
		mainModel.saveData();
	}

	public void resetUser() {
		mainModel.resetUser();
	}

	public void loadSignUp(JLabel wellcome, JButton signInBtn, JButton signUpBtn, JButton disconnectBtn, JButton myOrders) {
		mainModel.runSignUp(wellcome, signInBtn, signUpBtn, disconnectBtn, myOrders);
	}
	
	public void loadMyOrders() {
		mainModel.runMyOrders();
	}
}
