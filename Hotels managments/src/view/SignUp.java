package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.SignUpController;
import model.Customer;
import model.DarkMode;
import model.HotelRepo;
import model.UsersRepo;

public class SignUp extends DarkMode {
	private SignUpController signUpController;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES	
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();	
//RADIO BTNS
	public ArrayList<JRadioButton> radioBtns = new ArrayList<JRadioButton>();
		
	private JFrame frame;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneField;
	private JTextField mailField;
	private JTextField idField;
	private JPasswordField passwordField;
	
	private JRadioButton maleRadio = new JRadioButton("\u05D6\u05DB\u05E8");
	private JRadioButton femaleRadio = new JRadioButton("\u05E0\u05E7\u05D1\u05D4");
	
	private JLabel firstNameLabel = new JLabel("");
	private JLabel LastNameLabel = new JLabel("");
	private JLabel phoneNumberLabel = new JLabel("");
	private JLabel mailLabel = new JLabel("");
	private JLabel dateLabel = new JLabel("");
	private JLabel passwordLabel = new JLabel("");
	private JLabel idLabel = new JLabel("");
	private JLabel wellcome;
	
	private JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DD");
	
	private JComboBox<String> yearField = new JComboBox<>();
	private JComboBox<String> monthField = new JComboBox<>();
	private JComboBox<String> dayField = new JComboBox<>();
	
	private JButton startIn;
	private JButton startUp;
	private JButton startDis;
	private JButton myOrders;
	
//Launch the application.
	public void runSignUp(int darkFlag, JLabel wellcome, UsersRepo customers, HotelRepo hotelDB, JButton signInBtn, JButton signUpBtn, JButton disconnectBtn, Customer user, JButton myOrders) {
		EventQueue.invokeLater(() -> {
			try {
				SignUp window = new SignUp(darkFlag, wellcome, customers, hotelDB, signInBtn, signUpBtn, disconnectBtn, user, myOrders);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

//Create the application.
	public SignUp(int darkFlag, JLabel wellcome, UsersRepo customers, HotelRepo hotelDB, JButton signInBtn, JButton signUpBtn, JButton disconnectBtn, Customer user, JButton myOrders) {
		signUpController = new SignUpController(customers, hotelDB, user);
		this.wellcome = wellcome;
		this.startIn = signInBtn;
		this.startUp= signUpBtn;
		this.startDis = disconnectBtn;
		this.myOrders = myOrders;
		initialize();
		btnsEvents();
		setMode(darkFlag, frame, labels, btns, radioBtns, null);
	}

//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 585);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel signUpTitle = new JLabel("\u05D4\u05E8\u05E9\u05DE\u05D4 :");
    	JLabel firstNameTitle = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
    	JLabel lastNameTitle = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
    	JLabel phoneTitle = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF :");
    	JLabel mailTitle = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
    	JLabel idTitle = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA :");
    	JLabel genderTitle = new JLabel("\u05DE\u05D9\u05DF :");
    	JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
    	JLabel birthDayTitle = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");

    	labels.add(signUpTitle);
    	labels.add(firstNameTitle);
    	labels.add(lastNameTitle);
    	labels.add(phoneTitle);
    	labels.add(idTitle);
    	labels.add(mailTitle);
    	labels.add(idTitle);
    	labels.add(genderTitle);
    	labels.add(passwordTitle);
    	labels.add(birthDayTitle);
    	
    	btns.add(signUpBtn);
    	
    	radioBtns.add(femaleRadio);
    	radioBtns.add(maleRadio);
		
		signUpTitle.setBounds(179, 39, 65, 14);
		frame.getContentPane().add(signUpTitle);
		
		firstNameTitle.setBounds(334, 95, 80, 14);
		frame.getContentPane().add(firstNameTitle);
		
		lastNameTitle.setBounds(334, 132, 80, 14);
		frame.getContentPane().add(lastNameTitle);
		
		phoneTitle.setBounds(334, 168, 80, 14);
		frame.getContentPane().add(phoneTitle);
		
		mailTitle.setBounds(334, 204, 80, 14);
		frame.getContentPane().add(mailTitle);
		
		idTitle.setBounds(334, 243, 80, 14);
		frame.getContentPane().add(idTitle);
		
		genderTitle.setBounds(334, 286, 80, 14);
		frame.getContentPane().add(genderTitle);
		
		passwordTitle.setBounds(334, 329, 80, 14);
		frame.getContentPane().add(passwordTitle);
		
		birthDayTitle.setBounds(334, 368, 80, 14);
		frame.getContentPane().add(birthDayTitle);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(198, 92, 107, 20);
		firstNameField.setColumns(10);
		frame.getContentPane().add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(198, 129, 107, 20);
		frame.getContentPane().add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(198, 165, 107, 20);
		frame.getContentPane().add(phoneField);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(198, 201, 107, 20);
		frame.getContentPane().add(mailField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(198, 240, 107, 20);
		frame.getContentPane().add(idField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 326, 86, 20);
		frame.getContentPane().add(passwordField);
		
		firstNameLabel.setBounds(74, 95, 112, 14);
		frame.getContentPane().add(firstNameLabel);
		firstNameLabel.setForeground(Color.red);

		LastNameLabel.setBounds(74, 132, 112, 14);
		frame.getContentPane().add(LastNameLabel);
		LastNameLabel.setForeground(Color.red);
		
		phoneNumberLabel.setBounds(45, 168, 140, 14);
		frame.getContentPane().add(phoneNumberLabel);
		phoneNumberLabel.setForeground(Color.red);
		
		mailLabel.setBounds(74, 204, 112, 14);
		frame.getContentPane().add(mailLabel);
		mailLabel.setForeground(Color.red);
		
		dateLabel.setBounds(150, 396, 112, 14);
		frame.getContentPane().add(dateLabel);
		dateLabel.setForeground(Color.red);

		passwordLabel.setBounds(74, 329, 112, 14);
		frame.getContentPane().add(passwordLabel);
		passwordLabel.setForeground(Color.red);

		
		idLabel.setBounds(74, 243, 112, 14);
		frame.getContentPane().add(idLabel);
		idLabel.setForeground(Color.red);
		
		maleRadio.setBounds(252, 281, 52, 23);
		frame.getContentPane().add(maleRadio);
		
		femaleRadio.setBounds(179, 281, 65, 23);
		frame.getContentPane().add(femaleRadio);

		femaleRadio.setSelected(true);
		
		int i;

		yearField.addItem("Year");
		
		for(i=1;i<=120;i++)
			yearField.addItem(Integer.toString(2021-i));
		
		yearField.setBounds(229, 365, 76, 20);
		frame.getContentPane().add(yearField);
		
		monthField.setBounds(143, 366, 78, 20);
		frame.getContentPane().add(monthField);
		monthField.addItem("Month");
		
		for(i=1;i<=12;i++)
			monthField.addItem(Integer.toString(i));
		
		dayField.setBounds(45, 365, 86, 20);
		frame.getContentPane().add(dayField);
		
		dayField.addItem("Day");
		for(i=1;i<=31;i++)
			dayField.addItem(Integer.toString(i));
		
		signUpBtn.setBounds(130, 464, 150, 50);
		frame.getContentPane().add(signUpBtn, 65, 20);
		frame.getContentPane().add(monthField);
	}

	private void btnsEvents() {
//RADIO MALE
		maleRadio.addActionListener((ActionEvent arg0) -> {
			maleRadio.setSelected(true);
			femaleRadio.setSelected(false);
		});
//RADIO FEMALE
		femaleRadio.addActionListener((ActionEvent e) ->{
			maleRadio.setSelected(false);
			femaleRadio.setSelected(true);
		});
		
//SAVE BUTTON
		signUpBtn.addActionListener((ActionEvent e) -> {
			if(signUpController.validUser(firstNameField.getText(), firstNameLabel, lastNameField.getText(), LastNameLabel,
					phoneField.getText(), phoneNumberLabel, mailField.getText(), mailLabel, idField.getText(), idLabel,
					passwordField.getPassword(), passwordLabel, dayField.getSelectedIndex(), 
					monthField.getSelectedIndex(), yearField.getSelectedIndex(), dateLabel)) {
				boolean gen = true;
				if(femaleRadio.isSelected())
					gen = false;
				
				signUpController.addUser(new Customer(firstNameField.getText(), lastNameField.getText(), phoneField.getText(), mailField.getText(),
						 idField.getText(), gen, new String(passwordField.getPassword()), dayField.getSelectedIndex(),
						 monthField.getSelectedIndex(), 2021 - yearField.getSelectedIndex()));
				
				wellcome.setText("<html>Wellcome<br>" + firstNameField.getText()+"!<html>");
				
				signUpController.SetUser(firstNameField.getText(), lastNameField.getText(), phoneField.getText(), mailField.getText(),
						idField.getText(), gen, new String(passwordField.getPassword()), dayField.getSelectedIndex(),
						monthField.getSelectedIndex(), 2021 - yearField.getSelectedIndex());

				JOptionPane.showMessageDialog(null, firstNameField.getText() + " thank you for register!"); // CREATES MASSAGE
				startDis.setVisible(true);
				startUp.setVisible(false);
				startIn.setVisible(false);
				myOrders.setVisible(true);
				frame.dispose();
					}
				});
		}
}
