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
import javax.swing.JTextField;

import controller.AddRoomTypeController;
import model.DarkMode;
import model.Hotel;

public class AddRoomType extends DarkMode {
	
	private AddRoomTypeController addRoomController;
	private JFrame frame; 
	private JTextField capacityField;
	private JTextField priceField;
	private JTextField sizeField;
	private JTextField amountFIeld;
	
	private JLabel capacityError = new JLabel("");
	private JLabel priceError = new JLabel("");
	private JLabel sizeError = new JLabel("");
	private JLabel amountError = new JLabel("");
	private JLabel typeNameError;
	private JTextField typeNameField;
	private JLabel hotelname = new JLabel("");
	private JComboBox<String> roomTypes;

//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();

//Launch the application.
	public void RunAddRoom(Hotel hotel, JComboBox<String> roomTypes, int darkFlag) {
		EventQueue.invokeLater(() ->{
				try {
					AddRoomType window = new AddRoomType(hotel, roomTypes, darkFlag);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}

//Create the application.
	public AddRoomType(Hotel hotel, JComboBox<String> roomTypes, int darkFlag) {
		this.roomTypes = roomTypes;
		addRoomController = new AddRoomTypeController(hotel);
		initialize();
		setMode(darkFlag, frame, labels, btns, null, null);
	}

//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8 :");
		lblNewLabel.setBounds(108, 11, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		JLabel capacityTitle = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D0\u05E0\u05E9\u05D9\u05DD :");
		capacityTitle.setBounds(177, 118, 75, 14);
		frame.getContentPane().add(capacityTitle);
		labels.add(capacityTitle);
		
		JLabel priceTitle = new JLabel("\u05DE\u05D7\u05D9\u05E8 \u05DC\u05DC\u05D9\u05DC\u05D4 :");
		priceTitle.setBounds(177, 172, 75, 14);
		frame.getContentPane().add(priceTitle);
		labels.add(priceTitle);
		
		JLabel roomSizeTitle = new JLabel("\u05D2\u05D5\u05D3\u05DC \u05D7\u05D3\u05E8 :");
		roomSizeTitle.setBounds(176, 234, 75, 14);
		frame.getContentPane().add(roomSizeTitle);
		labels.add(roomSizeTitle);
		
		JLabel amountTitle = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D7\u05D3\u05E8\u05D9\u05DD \u05DE\u05D0\u05D5\u05EA\u05D5 \u05E1\u05D5\u05D2 :");
		amountTitle.setBounds(173, 293, 136, 14);
		frame.getContentPane().add(amountTitle);
		labels.add(amountTitle);
		
		capacityField = new JTextField();
		capacityField.setBounds(45, 117, 86, 20);
		frame.getContentPane().add(capacityField);
		capacityField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(46, 172, 86, 20);
		frame.getContentPane().add(priceField);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(45, 230, 86, 20);
		frame.getContentPane().add(sizeField);
		
		amountFIeld = new JTextField();
		amountFIeld.setColumns(10);
		amountFIeld.setBounds(45, 290, 86, 20);
		frame.getContentPane().add(amountFIeld);
		JButton addBtn = new JButton("\u05D4\u05D5\u05E1\u05E4 \u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8");
		btns.add(addBtn);
		
		addBtn.setBounds(92, 354, 132, 23);
		frame.getContentPane().add(addBtn);

		capacityError.setBounds(45, 147, 136, 14);
		capacityError.setForeground(Color.red);
		frame.getContentPane().add(capacityError);
		
		priceError.setBounds(45, 205, 136, 14);
		priceError.setForeground(Color.red);
		frame.getContentPane().add(priceError);
		
		sizeError.setBounds(45, 261, 156, 14);
		sizeError.setForeground(Color.red);
		frame.getContentPane().add(sizeError);
		
		amountError.setBounds(45, 322, 136, 14);
		amountError.setForeground(Color.red);
		frame.getContentPane().add(amountError);
		
		typeNameField = new JTextField();
		typeNameField.setBounds(45, 63, 86, 20);
		frame.getContentPane().add(typeNameField);
		typeNameField.setColumns(10);
		
		JLabel typeName = new JLabel("\u05E9\u05DD \u05D4\u05E1\u05D5\u05D2 :");
		typeName.setBounds(177, 66, 116, 14);
		frame.getContentPane().add(typeName);
		labels.add(typeName);
		
		typeNameError = new JLabel("");
		typeNameError.setBounds(45, 92, 156, 14);
		frame.getContentPane().add(typeNameError);
		
		hotelname.setBounds(126, 36, 75, 14);
		frame.getContentPane().add(hotelname);
		
		addBtn.addActionListener((ActionEvent arg0) -> {
			testFields();
		});
	}
	
	public void testFields() {
		if(addRoomController.validInput(typeNameField.getText(), capacityField.getText(),
				priceField.getText(), sizeField.getText(), amountFIeld.getText(),
				typeNameError, capacityError, priceError, sizeError, amountError)) {
			addRoomController.addRoom(typeNameField.getText() ,Integer.parseInt(capacityField.getText()), Double.parseDouble(priceField.getText()), Double.parseDouble(sizeField.getText()), Integer.parseInt(amountFIeld.getText()));
			roomTypes.addItem(typeNameField.getText());
			JOptionPane.showMessageDialog(null, typeNameField.getText() + " room type added to a hotel");
			typeNameField.setText("");
			capacityField.setText("");
			priceField.setText("");
			sizeField.setText("");
			amountFIeld.setText("");
		}
	}
}
