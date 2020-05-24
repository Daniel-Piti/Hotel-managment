package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Hotel;
import model.Validation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomType {

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
	private Hotel hotel;
	private JTextField typeNameField;

	public static void addRoomTypeForm(Hotel h) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomType window = new AddRoomType(h);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddRoomType(Hotel h) {
		hotel = h;
		setUI();
	}

	public void setUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8 :");
		lblNewLabel.setBounds(116, 11, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel capacityTitle = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D0\u05E0\u05E9\u05D9\u05DD :");
		capacityTitle.setBounds(177, 118, 75, 14);
		frame.getContentPane().add(capacityTitle);
		
		JLabel priceTitle = new JLabel("\u05DE\u05D7\u05D9\u05E8 \u05DC\u05DC\u05D9\u05DC\u05D4 :");
		priceTitle.setBounds(177, 172, 75, 14);
		frame.getContentPane().add(priceTitle);
		
		JLabel roomSizeTitle = new JLabel("\u05D2\u05D5\u05D3\u05DC \u05D7\u05D3\u05E8 :");
		roomSizeTitle.setBounds(176, 234, 75, 14);
		frame.getContentPane().add(roomSizeTitle);
		
		JLabel amountTitle = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D7\u05D3\u05E8\u05D9\u05DD \u05DE\u05D0\u05D5\u05EA\u05D5 \u05E1\u05D5\u05D2 :");
		amountTitle.setBounds(173, 293, 136, 14);
		frame.getContentPane().add(amountTitle);
		
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
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testFields();
			}
		});
		addBtn.setBounds(92, 354, 132, 23);
		frame.getContentPane().add(addBtn);

		capacityError.setBounds(45, 147, 86, 14);
		capacityError.setForeground(Color.red);
		frame.getContentPane().add(capacityError);
		
		priceError.setBounds(45, 205, 86, 14);
		priceError.setForeground(Color.red);
		frame.getContentPane().add(priceError);
		
		sizeError.setBounds(45, 261, 86, 14);
		sizeError.setForeground(Color.red);
		frame.getContentPane().add(sizeError);
		
		amountError.setBounds(45, 322, 86, 14);
		amountError.setForeground(Color.red);
		frame.getContentPane().add(amountError);
		
		typeNameField = new JTextField();
		typeNameField.setBounds(45, 63, 86, 20);
		frame.getContentPane().add(typeNameField);
		typeNameField.setColumns(10);
		
		JLabel typeName = new JLabel("\u05E9\u05DD \u05D4\u05E1\u05D5\u05D2 :");
		typeName.setBounds(177, 66, 116, 14);
		frame.getContentPane().add(typeName);
		
		typeNameError = new JLabel("");
		typeNameError.setBounds(45, 92, 86, 14);
		frame.getContentPane().add(typeNameError);
	}
	
	public void testFields() {
		System.out.println(hotel.toString());
		Validation v = new Validation();
		boolean flag = true;
	//typeName
		if(!v.validNotEmpty(typeNameField.getText(), typeNameError))
			flag = false;
	//capacity
		if(!v.validNumber(capacityField.getText(), capacityError))
			flag = false;
	//price
		if(!v.validDouble(priceField.getText(), priceError))
			flag = false;
	//size
		if(!v.validDouble(sizeField.getText(), sizeError))
			flag = false;
	//amount
		if(!v.validNumber(amountFIeld.getText(), amountError))
			flag = false;
		
		if(flag) {
			hotel.addRoomType(typeNameField.getText() ,Integer.parseInt(capacityField.getText()), Double.parseDouble(priceField.getText()), Double.parseDouble(sizeField.getText()), Integer.parseInt(amountFIeld.getText()));
			System.out.println(typeNameField.getText() + "room type added to a hotel");
			JOptionPane.showMessageDialog(null, typeNameField.getText() + "room type added to a hotel");
			typeNameField.setText("");
			capacityField.setText("");
			priceField.setText("");
			sizeField.setText("");
			amountFIeld.setText("");
		}
	}
}
