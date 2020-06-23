package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.SignInController;
import model.Customer;
import model.DarkMode;
import model.HotelRepo;
import model.UsersRepo;
import java.awt.event.ActionEvent;

public class SignInView {

	protected static final UsersRepo UsersRepo = null;
	private SignInController signInController;
	private JFrame frame;
	private JTextField mailField;
	private JPasswordField passwordField;
	private JButton signInBtn;
	private JLabel errorLabel;
	private int dark;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();

//Launch the application.
	public void runSignIn(int darkFlag,JLabel wellcome, Customer user, UsersRepo customers, HotelRepo hotelDB, JButton in, JButton up, JButton dis){
		EventQueue.invokeLater(()->{
				try {
					SignInView window = new SignInView(darkFlag, wellcome, user, customers, hotelDB, in, up, dis);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
	}

//Create the application.
	public SignInView(int darkFlag, JLabel wellcome, Customer user, UsersRepo users, HotelRepo hotels,JButton in, JButton up, JButton dis) {
		signInController = new SignInController(wellcome, user, users, hotels, in, up, dis, darkFlag);
		initialize();
		dark = darkFlag;
		new DarkMode(dark, frame, labels, btns, null, null);
		frame.getContentPane().setLayout(null);
		listeners();
	}

//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel mailTitle = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
		mailTitle.setBounds(301, 47, 69, 20);
		frame.getContentPane().add(mailTitle);
		labels.add(mailTitle);
		
		JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		passwordTitle.setBounds(301, 115, 69, 20);
		frame.getContentPane().add(passwordTitle);
		labels.add(passwordTitle);
		
		mailField = new JTextField();
		mailField.setBounds(73, 44, 146, 26);
		frame.getContentPane().add(mailField);
		mailField.setColumns(10);
		
		signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8 !");
			
		errorLabel = new JLabel("");
		errorLabel.setBounds(76, 149, 197, 14);
		errorLabel.setForeground(Color.red);
		frame.getContentPane().add(errorLabel);

		signInBtn.setBounds(73, 174, 146, 29);
		frame.getContentPane().add(signInBtn);
		btns.add(signInBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 112, 146, 26);
		frame.getContentPane().add(passwordField);
	}
	
	public void listeners() {
		signInBtn.addActionListener((ActionEvent e) -> {
//PROJECT MASTER
			if(signInController.checkProjManaget(mailField.getText(), String.valueOf(passwordField.getPassword())) == true)
				frame.dispose();
//HOTEL MANAGER
			else if(signInController.checkHotels(mailField.getText(), String.valueOf(passwordField.getPassword())) == true)
				frame.dispose();
//checkUsers	
			else if(signInController.checkUsers(mailField.getText(), String.valueOf(passwordField.getPassword())) == true)
				frame.dispose();
			errorLabel.setText("Empty / somthing worng!");
		});
	}

}
