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
import javax.swing.JTextField;

import controller.AddHotelController;
import model.DarkFlag;
import model.DarkMode;

public class AddHotel extends DarkMode {
	private JFrame frame;
	
	private JTextField hotelNameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField mailField;
	
	private JLabel nameError;
	private JLabel addressError;
	private JLabel phoneError;
	private JLabel pass;
	private JLabel lblNewLabel_2;
	private JLabel passwordError;
	private JLabel mailError;
	private JPasswordField passwordField;
	private JComboBox<String> deleteHotelCombo;
	private JComboBox<String> comboBox;
	private JButton addHotelBTN;
	private JButton deleteHotelbtn;
//BUTTONS
	private ArrayList<JButton> btns = new ArrayList<JButton>();
		
//JLABLES
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
// Launch the application.
	private AddHotelController addHotelController;
	private JTextField userMailField;

	public void RunAddHotel() {
		EventQueue.invokeLater(() -> {
			try {
				AddHotel window = new AddHotel();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

//Create the application.
	public AddHotel() {
		addHotelController = new AddHotelController();
		initialize();
		listeners();
		setMode(DarkFlag.getInstance(), frame, labels, btns, null, null);
	}

//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 325);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05DC\u05D5\u05DF :");
		lblNewLabel.setBounds(162, 29, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		JLabel hotelNameTitle = new JLabel("\u05E9\u05DD \u05D4\u05DE\u05DC\u05D5\u05DF :");
		hotelNameTitle.setBounds(317, 92, 80, 14);
		frame.getContentPane().add(hotelNameTitle);
		labels.add(hotelNameTitle);
		
		JLabel addressTitle = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		addressTitle.setBounds(318, 140, 46, 14);
		frame.getContentPane().add(addressTitle);
		labels.add(addressTitle);
		
		JLabel starsTitle = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DB\u05D5\u05DB\u05D1\u05D9\u05DD :");
		starsTitle.setBounds(120, 185, 96, 14);
		frame.getContentPane().add(starsTitle);
		labels.add(starsTitle);
		
		JLabel phoneNumberTitle = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF :");
		phoneNumberTitle.setBounds(318, 185, 46, 14);
		frame.getContentPane().add(phoneNumberTitle);
		labels.add(phoneNumberTitle);
		
		addHotelBTN = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05DC\u05D5\u05DF");
		btns.add(addHotelBTN);
		
		addHotelBTN.setBounds(24, 228, 170, 23);
		frame.getContentPane().add(addHotelBTN);
		
		hotelNameField = new JTextField();
		hotelNameField.setBounds(221, 89, 86, 20);
		frame.getContentPane().add(hotelNameField);
		hotelNameField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setBounds(218, 137, 86, 20);
		frame.getContentPane().add(addressField);
		addressField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(218, 182, 86, 20);
		frame.getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		nameError = new JLabel("");
		nameError.setBounds(224, 117, 140, 14);
		nameError.setForeground(Color.red);
		frame.getContentPane().add(nameError);
		
		addressError = new JLabel("");
		addressError.setBounds(221, 160, 140, 14);
		addressError.setForeground(Color.red);
		frame.getContentPane().add(addressError);
		
		phoneError = new JLabel("");
		phoneError.setBounds(221, 207, 130, 14);
		phoneError.setForeground(Color.red);
		frame.getContentPane().add(phoneError);
//DISIGN ERROR
		String s[] = new String[] {"1","2","3","4","5"};
		comboBox = new JComboBox<String>(s);
		comboBox.setBounds(34, 182, 50, 20);
		frame.getContentPane().add(comboBox);
		
		pass = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		pass.setBounds(120, 140, 74, 14);
		frame.getContentPane().add(pass);
		labels.add(pass);

		
		lblNewLabel_2 = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
		lblNewLabel_2.setBounds(318, 232, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		labels.add(lblNewLabel_2);

		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(218, 229, 86, 20);
		frame.getContentPane().add(mailField);
		
		passwordError = new JLabel("");
		passwordError.setForeground(Color.RED);
		passwordError.setBounds(24, 160, 130, 14);
		frame.getContentPane().add(passwordError);
		
		mailError = new JLabel("");
		mailError.setForeground(Color.RED);
		mailError.setBounds(221, 257, 130, 14);
		frame.getContentPane().add(mailError);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 137, 86, 20);
		frame.getContentPane().add(passwordField);
		
		deleteHotelCombo = new JComboBox<String>();
		deleteHotelCombo.setBounds(420,76,100,27);
		frame.getContentPane().add(deleteHotelCombo);
		
		JLabel deleteHotelLabel = new JLabel("\u05DE\u05D7\u05E7 \u05DE\u05DC\u05D5\u05DF :");
		deleteHotelLabel.setBounds(444,42,96,16);
		frame.getContentPane().add(deleteHotelLabel);
		labels.add(deleteHotelLabel);
		
		addHotelController.loadHotelList(deleteHotelCombo);
		
		deleteHotelbtn = new JButton("Delete hotel");
		deleteHotelbtn.setBounds(412,133,117,29);
		frame.getContentPane().add(deleteHotelbtn);
		btns.add(deleteHotelbtn);	
		
		JLabel userName = new JLabel("\u05DE\u05D9\u05D9\u05DC \u05DE\u05E9\u05EA\u05DE\u05E9 :");
		userName.setBounds(120, 92, 91, 14);
		frame.getContentPane().add(userName);
		
		userMailField = new JTextField();
		userMailField.setBounds(24, 89, 86, 20);
		frame.getContentPane().add(userMailField);
		userMailField.setColumns(10);
		
		JLabel userMailError = new JLabel("");
		userMailError.setBounds(24, 117, 164, 14);
		frame.getContentPane().add(userMailError);
	}

	private void listeners() {
		addHotelBTN.addActionListener((ActionEvent arg0) -> {
				if(addHotelController.validHotel(hotelNameField.getText(), addressField.getText(), phoneField.getText(), passwordField.getPassword(), mailField.getText(), 
						nameError, addressError, phoneError, passwordError, mailError, comboBox.getSelectedIndex() + 1, userMailField.getText()) == true) {
					hotelNameField.setText("");
					addressField.setText("");
					phoneField.setText("");
					passwordField.setText("");
					mailField.setText("");
					userMailField.setText("");
					deleteHotelCombo.addItem(hotelNameField.getText());
					JOptionPane.showMessageDialog(null, hotelNameField.getText() + " hotel added");
				}
		});
		
		deleteHotelbtn.addActionListener((ActionEvent e)-> {
				if(deleteHotelCombo.getItemCount() > 0) {
					int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete the hotel ?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						addHotelController.removeHotel(deleteHotelCombo.getSelectedIndex());
						deleteHotelCombo.removeItemAt(deleteHotelCombo.getSelectedIndex());
					}
				}
		});
	}
}
