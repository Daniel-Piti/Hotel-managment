package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import model.DarkMode;
import model.Hotel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditHotel {

	private JFrame frame;
	private Hotel hotel;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JPasswordField passwordField;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();		
	
	/**
	 * Launch the application.
	 */
	public void editHotelForm(Hotel h, int dark) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditHotel window = new EditHotel(h, dark);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditHotel(Hotel h, int dark) {
		hotel = h;
		initialize(dark);
		DarkMode d = new DarkMode();
		if(dark == 0)
			d.setLightMode(frame, labels, btns, null, null);
		else
			d.setDarkMode(frame, labels, btns, null, null);
	}
	
	// Initialize the contents of the frame.
	
	private void initialize(int dark) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 367);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameTitle = new JLabel("\u05E9\u05DD \u05D4\u05DE\u05DC\u05D5\u05DF :");
		nameTitle.setBounds(325, 74, 74, 14);
		frame.getContentPane().add(nameTitle);
		labels.add(nameTitle);
		
		JLabel addressTitle = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		addressTitle.setBounds(325, 132, 74, 14);
		frame.getContentPane().add(addressTitle);
		labels.add(addressTitle);
		
		JLabel phoneTitle = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF :");
		phoneTitle.setBounds(325, 190, 74, 14);
		frame.getContentPane().add(phoneTitle);
		labels.add(phoneTitle);
		
		JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		passwordTitle.setBounds(325, 249, 74, 14);
		frame.getContentPane().add(passwordTitle);
		labels.add(passwordTitle);
		
		nameField = new JTextField();
		nameField.setBounds(229, 71, 86, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(229, 129, 86, 20);
		frame.getContentPane().add(addressField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(229, 187, 86, 20);
		frame.getContentPane().add(phoneField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 246, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel nameError = new JLabel("");
		nameError.setBounds(229, 102, 46, 14);
		nameError.setForeground(Color.red);
		frame.getContentPane().add(nameError);
		
		JLabel addressError = new JLabel("");
		addressError.setBounds(229, 160, 46, 14);
		addressError.setForeground(Color.red);
		frame.getContentPane().add(addressError);
		
		JLabel phoneError = new JLabel("");
		phoneError.setBounds(229, 221, 46, 14);
		phoneError.setForeground(Color.red);
		frame.getContentPane().add(phoneError);
		
		JLabel passwordError = new JLabel("");
		passwordError.setBounds(229, 283, 46, 14);
		passwordError.setForeground(Color.red);
		frame.getContentPane().add(passwordError);
		
		JButton addRoomTypeBtn = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E1\u05D5\u05D2\u05D9 \u05D7\u05D3\u05E8");
		btns.add(addRoomTypeBtn);
		
		JComboBox<String> roomTypes = new JComboBox<String>();
		for(int i = 0; i < hotel.roomTypes.size(); i++)
			roomTypes.addItem(hotel.roomTypes.get(i).typeName);
		
		
		addRoomTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRoomType a = new AddRoomType(hotel, roomTypes, dark);
				a.addRoomTypeForm(hotel, roomTypes, dark);
			}
		});
		addRoomTypeBtn.setBounds(49, 186, 113, 23);
		frame.getContentPane().add(addRoomTypeBtn);
		
		roomTypes.setBounds(49, 129, 113, 20);
		frame.getContentPane().add(roomTypes);
		
		JLabel lblNewLabel = new JLabel("\u05E1\u05D5\u05D2\u05D9 \u05D7\u05D3\u05E8\u05D9\u05DD");
		lblNewLabel.setBounds(76, 74, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		JButton editBtn = new JButton("\u05E2\u05D3\u05DB\u05DF");
		btns.add(editBtn);
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hotel.editHotel(nameField.getText(), addressField.getText(), phoneField.getText(), String.valueOf(passwordField.getPassword()));
				JOptionPane.showMessageDialog(null, "Hotel editted successfuly");
			}
		});
		editBtn.setBounds(61, 245, 89, 23);
		frame.getContentPane().add(editBtn);
		
		nameField.setText(hotel.getName());
		addressField.setText(hotel.getAddress());
		phoneField.setText(hotel.getPhone());
		passwordField.setText(hotel.getPassword());
		
		JLabel title = new JLabel("\u05E2\u05E8\u05D9\u05DB\u05EA \u05DE\u05DC\u05D5\u05DF :");
		title.setBounds(169, 23, 79, 14);
		frame.getContentPane().add(title);
		labels.add(title);
	}
}
