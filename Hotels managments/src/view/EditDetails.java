 package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.EditDetailsController;
import model.Customer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDetails {
	
	private EditDetailsController editDetailsController;
	private JFrame frame;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField phoneField;
	private JTextField passField;
	private JButton updateBtn;
	
	public void runEditDetails(Customer user) {
		EventQueue.invokeLater(() -> {
			try {
				EditDetails window = new EditDetails(user);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public EditDetails(Customer user) {
		editDetailsController = new EditDetailsController(user);
		initialize();
		editDetailsController.loadFields(firstnameField, lastnameField, phoneField, passField);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 263, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("\u05E2\u05E8\u05D9\u05DB\u05EA \u05E4\u05E8\u05D8\u05D9\u05DD");
		title.setBounds(88, 11, 149, 14);
		frame.getContentPane().add(title);
		
		JLabel firstNameTitle = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
		firstNameTitle.setBounds(131, 48, 91, 14);
		frame.getContentPane().add(firstNameTitle);
		
		JLabel lastNameTitle = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
		lastNameTitle.setBounds(131, 85, 91, 14);
		frame.getContentPane().add(lastNameTitle);
		
		JLabel phoneNumberTitle = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF :");
		phoneNumberTitle.setBounds(131, 124, 91, 14);
		frame.getContentPane().add(phoneNumberTitle);
		
		JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		passwordTitle.setBounds(131, 171, 91, 14);
		frame.getContentPane().add(passwordTitle);
		
		firstnameField = new JTextField();
		firstnameField.setBounds(21, 45, 86, 20);
		frame.getContentPane().add(firstnameField);
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(21, 82, 86, 20);
		frame.getContentPane().add(lastnameField);
		lastnameField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(21, 124, 86, 20);
		frame.getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(21, 168, 86, 20);
		frame.getContentPane().add(passField);
		passField.setColumns(10);
		
		updateBtn = new JButton("\u05E2\u05D3\u05DB\u05DF");
		updateBtn.addActionListener((ActionEvent arg0) -> {
			try {
				editDetailsController.upDateDetails(firstnameField.getText(), lastnameField.getText(), phoneField.getText(), passField.getText());
				JOptionPane.showMessageDialog(null, "Your details are saved !");
			} catch(Exception e) {
				System.out.println("somthing went wrong!");
			}
		});
		updateBtn.setBounds(73, 227, 89, 23);
		frame.getContentPane().add(updateBtn);
	}
}
