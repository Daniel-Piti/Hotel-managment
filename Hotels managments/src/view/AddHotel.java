package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.DarkMode;
import model.Hotel;
import model.HotelRepo;
import model.UsersRepo;
import model.Validation;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddHotel {

	private JFrame frame;
	private HotelRepo hotelsDB;
	private UsersRepo users;
	
	private JTextField hotelNameField;
	private JTextField addressField;
	private JTextField phoneField;
	
	private JLabel nameError;
	private JLabel addressError;
	private JLabel phoneError;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField mailField;
	private JLabel passwordError;
	private JLabel mailError;
	private JPasswordField passwordField;
	//BUTTONS
		public ArrayList<JButton> btns = new ArrayList<JButton>();
	//JLABLES
		public ArrayList<JLabel> labels = new ArrayList<JLabel>();
	/**
	 * Launch the application.
	 */
	public void addHotelform(HotelRepo h, UsersRepo c, int dark) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHotel window = new AddHotel(h, c, dark);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddHotel(HotelRepo h, UsersRepo c, int dark) {
		hotelsDB = h;
		users = c;
		initialize();
		DarkMode d = new DarkMode();
		if(dark == 0)
			d.setLightMode(frame, labels, btns, null, null);
		else
			d.setDarkMode(frame, labels, btns, null, null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 442);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05DC\u05D5\u05DF :");
		lblNewLabel.setBounds(162, 29, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		JLabel hotelNameTitle = new JLabel("\u05E9\u05DD \u05D4\u05DE\u05DC\u05D5\u05DF :");
		hotelNameTitle.setBounds(257, 92, 80, 14);
		frame.getContentPane().add(hotelNameTitle);
		labels.add(hotelNameTitle);
		
		JLabel addressTitle = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		addressTitle.setBounds(257, 140, 46, 14);
		frame.getContentPane().add(addressTitle);
		labels.add(addressTitle);
		
		JLabel starsTitle = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DB\u05D5\u05DB\u05D1\u05D9\u05DD :");
		starsTitle.setBounds(257, 326, 96, 14);
		frame.getContentPane().add(starsTitle);
		labels.add(starsTitle);
		
		JLabel phoneNumberTitle = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF :");
		phoneNumberTitle.setBounds(257, 185, 46, 14);
		frame.getContentPane().add(phoneNumberTitle);
		labels.add(phoneNumberTitle);
		
		JButton btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05DC\u05D5\u05DF");
		btns.add(btnNewButton);
		
		btnNewButton.setBounds(93, 369, 184, 23);
		frame.getContentPane().add(btnNewButton);
		
		hotelNameField = new JTextField();
		hotelNameField.setBounds(150, 89, 86, 20);
		frame.getContentPane().add(hotelNameField);
		hotelNameField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setBounds(150, 137, 86, 20);
		frame.getContentPane().add(addressField);
		addressField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(150, 182, 86, 20);
		frame.getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		nameError = new JLabel("");
		nameError.setBounds(0, 92, 140, 14);
		nameError.setForeground(Color.red);
		frame.getContentPane().add(nameError);
		
		addressError = new JLabel("");
		addressError.setBounds(0, 140, 140, 14);
		addressError.setForeground(Color.red);
		frame.getContentPane().add(addressError);
		
		phoneError = new JLabel("");
		phoneError.setBounds(10, 185, 130, 14);
		phoneError.setForeground(Color.red);
		frame.getContentPane().add(phoneError);
	//DISIGN ERROR
		String s[] = new String[] {"1","2","3","4","5"};
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(164, 323, 50, 20);
		frame.getContentPane().add(comboBox);
		
		lblNewLabel_1 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		lblNewLabel_1.setBounds(257, 229, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
		lblNewLabel_2.setBounds(257, 275, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(150, 272, 86, 20);
		frame.getContentPane().add(mailField);
		
		passwordError = new JLabel("");
		passwordError.setForeground(Color.RED);
		passwordError.setBounds(10, 229, 130, 14);
		frame.getContentPane().add(passwordError);
		
		mailError = new JLabel("");
		mailError.setForeground(Color.RED);
		mailError.setBounds(10, 275, 130, 14);
		frame.getContentPane().add(mailError);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 226, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JComboBox deleteHotelCombo = new JComboBox();
		deleteHotelCombo.setBounds(44, 321, 52, 27);
		frame.getContentPane().add(deleteHotelCombo);
		
		
		JLabel deleteHotelLabel = new JLabel("מחק מלון");
		deleteHotelLabel.setBounds(20, 293, 96, 16);
		frame.getContentPane().add(deleteHotelLabel);
		labels.add(deleteHotelLabel);
		
		for(int i=0;i<hotelsDB.hotels.size();i++) {
			deleteHotelCombo.addItem(hotelsDB.hotels.get(i).getName());
		}
		
		JButton deleteHotelbtn = new JButton("מחק");
		deleteHotelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){

					hotelsDB.hotels.remove(deleteHotelCombo.getSelectedIndex());
					deleteHotelCombo.removeItemAt(deleteHotelCombo.getSelectedIndex());
				}
			
				
			}
		});
		deleteHotelbtn.setBounds(6, 343, 117, 29);
		frame.getContentPane().add(deleteHotelbtn);
		btns.add(deleteHotelbtn);
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = true;
				Validation v = new Validation();
				if(!v.validNotEmpty(hotelNameField.getText(), nameError))
					flag = false;
				
				if(!v.validNotEmpty(addressField.getText(), addressError))
					flag = false;
				
				if(!v.validPhone(phoneField.getText(), phoneError))
					flag = false;
				
				if(!v.validPassword(passwordField.getPassword(), passwordError))
					flag = false;
				
				if(!v.validEmail(mailField.getText(), mailError))
					flag = false;
			//users db
				if(users.emailUsed(mailField.getText()) || hotelsDB.emailUsed(mailField.getText())) {
					mailError.setText("Email allready used");
					flag = false;
				}
				
				if(flag) {
					hotelsDB.addHotel(new Hotel(hotelNameField.getText(), addressField.getText(), phoneField.getText(), String.valueOf(passwordField.getPassword()), mailField.getText(), comboBox.getSelectedIndex() + 1));
					JOptionPane.showMessageDialog(null, hotelNameField.getText() + " hotel added");
					hotelNameField.setText("");
					addressField.setText("");
					phoneField.setText("");
					passwordField.setText("");
					mailField.setText("");
				}
			}
		});
	}
}
