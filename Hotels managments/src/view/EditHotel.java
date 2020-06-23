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

import controller.EditHotelController;
import model.DarkMode;
import model.Hotel;

public class EditHotel {
	private EditHotelController editHotelController;
	private JFrame frame;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JPasswordField passwordField;
	private JButton addRoomTypeBtn;
	private JButton editBtn;
	private int darkFlag;
	private JComboBox<String> roomTypes;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();	

//Launch the application.
	public void runEditHotel(Hotel h, int dark) {
		EventQueue.invokeLater(()-> {
			try {
				EditHotel window = new EditHotel(h, dark);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

//Create the application.
	public EditHotel(Hotel h, int dark) {
		darkFlag = dark;
		editHotelController = new EditHotelController(h);
		initialize();
		listener();
		new DarkMode(dark, frame, labels, btns, null, null);
	}

//Initialize the contents of the frame.
	private void listener() {
		addRoomTypeBtn.addActionListener((ActionEvent arg0) -> {
			editHotelController.loadAddRoomType(roomTypes ,darkFlag);
		});
		
		editBtn.addActionListener((ActionEvent arg0) -> {
			editHotelController.editHotelModel.hotel.editHotel(nameField.getText(), addressField.getText(), phoneField.getText(), String.valueOf(passwordField.getPassword()));
			JOptionPane.showMessageDialog(null, "Hotel editted successfuly");
		});
	}

	private void initialize() {
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
		
		JLabel passwordError = new JLabel("");
		passwordError.setBounds(229, 283, 86, 14);
		passwordError.setForeground(Color.red);
		frame.getContentPane().add(passwordError);
		
		addRoomTypeBtn = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8");
		addRoomTypeBtn.setBounds(51, 214, 109, 24);
		btns.add(addRoomTypeBtn);
		frame.getContentPane().add(addRoomTypeBtn);
		
		roomTypes = new JComboBox<String>();
		for(int i = 0; i < editHotelController.editHotelModel.hotel.roomTypes.size(); i++)
			roomTypes.addItem(editHotelController.editHotelModel.hotel.roomTypes.get(i).typeName);
		roomTypes.setBounds(49, 129, 113, 20);
		frame.getContentPane().add(roomTypes);
		
		JLabel lblNewLabel = new JLabel("\u05E1\u05D5\u05D2\u05D9 \u05D7\u05D3\u05E8\u05D9\u05DD");
		lblNewLabel.setBounds(76, 74, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		editBtn = new JButton("\u05E2\u05D3\u05DB\u05DF");
		btns.add(editBtn);
		editBtn.setBounds(59, 274, 89, 23);
		frame.getContentPane().add(editBtn);
		
		editHotelController.loadFields(nameField, addressField, phoneField, passwordField);
		
		JLabel title = new JLabel("\u05E2\u05E8\u05D9\u05DB\u05EA \u05DE\u05DC\u05D5\u05DF :");
		title.setBounds(169, 23, 79, 14);
		frame.getContentPane().add(title);
		labels.add(title);
		
		JButton deleteRoomBtn = new JButton("\u05DE\u05D7\u05E7 \u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8");
		deleteRoomBtn.addActionListener((ActionEvent arg0) -> {
			if(roomTypes.getItemCount() > 0) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete the room type ?","Warning",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					editHotelController.removeRoom(roomTypes.getSelectedIndex());
					roomTypes.removeItemAt(roomTypes.getSelectedIndex());
				}
			}
		});
		deleteRoomBtn.setBounds(52, 170, 107, 25);
		frame.getContentPane().add(deleteRoomBtn);
		btns.add(deleteRoomBtn);
	}
}
