package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.OrderController;
import model.Customer;
import model.DarkFlag;
import model.DarkMode;
import model.Hotel;

public class Order extends DarkMode {
	private OrderController orderController;
	private JFrame frame;
	private JTextField cardNameField;
	private JTextField cvcField;
	private JLabel startDate;
	private JLabel endDate;
	private JComboBox<String> startYear;
	private JComboBox<String> startMonth;
	private JComboBox<String> startDay;
	private JComboBox<String> endYear;
	private JComboBox<String> endMonth;
	private JComboBox<String> endDay;
	private JLabel roomTypeTitle;
	private JComboBox<String> roomTypeCombo;
	private JLabel hotelName;
	private JLabel creditCardTitle;
	private JLabel cardNumberTitle;
	private JLabel cvcTitle;
	private JLabel dateTitle;
	private JComboBox<String> cardYear;
	private JComboBox<String> cardMonth;
	private JLabel startDateError;
	private JLabel endDateError;
	private JButton orderNow;
	private JLabel roomTypeError;
	private JLabel cardError;
	private JLabel roomDesc;
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES	
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private JLabel checkError;
	private JLabel lblNewLabel;
	private JLabel totalPrice;
	private JButton priceBtn;

//Launch the application.
	public void runOrder(Hotel hotel, Customer user) {
		EventQueue.invokeLater(() -> {
			try {
				Order window = new Order(hotel, user);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

//Create the application.
	public Order(Hotel hotel, Customer user) {
		orderController = new OrderController(hotel, user);
		initialize();
		setMode(DarkFlag.getInstance(), frame, labels, btns, null, null);
	}

//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 398, 480);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		startDate = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4 :");
		startDate.setBounds(273, 66, 95, 14);
		frame.getContentPane().add(startDate);
		labels.add(startDate);
		
		endDate = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD :");
		endDate.setBounds(273, 121, 95, 14);
		frame.getContentPane().add(endDate);
		labels.add(endDate);
		
		startYear = new JComboBox<String>();
		startYear.setBounds(196, 63, 67, 20);
		frame.getContentPane().add(startYear);
		
		startMonth = new JComboBox<String>();
		startMonth.setBounds(111, 63, 71, 20);
		frame.getContentPane().add(startMonth);
		
		startDay = new JComboBox<String>();
		startDay.setBounds(34, 63, 58, 20);
		frame.getContentPane().add(startDay);
		
		endYear = new JComboBox<String>();
		endYear.setBounds(196, 118, 67, 20);
		frame.getContentPane().add(endYear);
		
		endMonth = new JComboBox<String>();
		endMonth.setBounds(112, 118, 70, 20);
		frame.getContentPane().add(endMonth);
		
		endDay = new JComboBox<String>();
		endDay.setBounds(34, 118, 58, 20);
		frame.getContentPane().add(endDay);
		
		roomTypeTitle = new JLabel("\u05E1\u05D5\u05D2 \u05D7\u05D3\u05E8 :");
		roomTypeTitle.setBounds(306, 180, 66, 14);
		frame.getContentPane().add(roomTypeTitle);
		labels.add(roomTypeTitle);
		
		roomTypeCombo = new JComboBox<String>();
		roomTypeCombo.setBounds(225, 177, 71, 20);
		frame.getContentPane().add(roomTypeCombo);
		
		hotelName = new JLabel("hotel name");
		hotelName.setBounds(139, 11, 168, 14);
		frame.getContentPane().add(hotelName);
		hotelName.setText("Hotel : " + orderController.getHotelName());
		labels.add(hotelName);
		
		creditCardTitle = new JLabel("\u05DB\u05E8\u05D8\u05D9\u05E1 \u05D0\u05E9\u05E8\u05D0\u05D9");
		creditCardTitle.setBounds(161, 273, 107, 14);
		frame.getContentPane().add(creditCardTitle);
		labels.add(creditCardTitle);
		
		cardNumberTitle = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DB\u05E8\u05D8\u05D9\u05E1 :");
		cardNumberTitle.setBounds(261, 298, 113, 14);
		frame.getContentPane().add(cardNumberTitle);
		labels.add(cardNumberTitle);
		
		cvcTitle = new JLabel(": CVC");
		cvcTitle.setBounds(261, 379, 46, 14);
		frame.getContentPane().add(cvcTitle);
		labels.add(cvcTitle);
		
		dateTitle = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05EA\u05E4\u05D5\u05D2\u05D4 :");
		dateTitle.setBounds(259, 340, 107, 14);
		frame.getContentPane().add(dateTitle);
		labels.add(dateTitle);
		
		cardYear = new JComboBox<String>();
		cardYear.setBounds(163, 337, 68, 20);
		frame.getContentPane().add(cardYear);
		
		cardMonth = new JComboBox<String>();
		cardMonth.setBounds(77, 337, 71, 20);
		frame.getContentPane().add(cardMonth);
		
		cardNameField = new JTextField();
		cardNameField.setBounds(77, 295, 157, 20);
		frame.getContentPane().add(cardNameField);
		cardNameField.setColumns(10);
		
		cvcField = new JTextField();
		cvcField.setBounds(163, 376, 58, 20);
		frame.getContentPane().add(cvcField);
		cvcField.setColumns(10);
		
		startDateError = new JLabel("");
		startDateError.setBounds(107, 93, 107, 14);
		frame.getContentPane().add(startDateError);
		startDateError.setForeground(Color.red);

		endDateError = new JLabel("");
		endDateError.setBounds(111, 149, 157, 14);
		frame.getContentPane().add(endDateError);
		endDateError.setForeground(Color.red);

		roomTypeError = new JLabel("");
		roomTypeError.setBounds(25, 246, 146, 14);
		frame.getContentPane().add(roomTypeError);
		roomTypeError.setForeground(Color.red);
		
		checkError = new JLabel("");
		checkError.setBounds(160, 150, 146, 14);
		frame.getContentPane().add(checkError);
		checkError.setForeground(Color.green);
		
		int i;
		orderController.loadRoomTypes(roomTypeCombo);
		
		startDay.addItem("Day");
		endDay.addItem("Day");
		for(i=1;i<=31;i++) {
			startDay.addItem(Integer.toString(i));
			endDay.addItem(Integer.toString(i));
		}

		startMonth.addItem("Month");
		endMonth.addItem("Month");
		cardMonth.addItem("Month");
		for(i=1;i<=12;i++) {
			startMonth.addItem(Integer.toString(i));
			endMonth.addItem(Integer.toString(i));
			cardMonth.addItem(Integer.toString(i));
		}
		
		startYear.addItem("Year");
		endYear.addItem("Year");
		cardYear.addItem("Year");
		for(i = 1; i < 3; i++) {
			startYear.addItem(Integer.toString(2019 + i));
			endYear.addItem(Integer.toString(2019 + i));
		}
		for(i = 1; i <= 10; i++)
			cardYear.addItem(Integer.toString(2019 + i));
		
		
		orderNow = new JButton("Order now!");
		orderNow.setBounds(10, 407, 362, 23);
		frame.getContentPane().add(orderNow);
		btns.add(orderNow);
		
		cardError = new JLabel("");
		cardError.setBounds(10, 382, 95, 14);
		frame.getContentPane().add(cardError);
		
		lblNewLabel = new JLabel("\u05E1\u05D4\"\u05DB :");
		lblNewLabel.setBounds(173, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		labels.add(lblNewLabel);
		
		totalPrice = new JLabel("0 $");
		totalPrice.setBounds(111, 180, 58, 14);
		frame.getContentPane().add(totalPrice);
		labels.add(totalPrice);
		
		priceBtn = new JButton("<html>Check<br>price<html>");
		priceBtn.setBounds(25, 169, 80, 36);
		frame.getContentPane().add(priceBtn);
		btns.add(priceBtn);
		
		roomDesc = new JLabel("");
		roomDesc.setBounds(225, 208, 117, 64);
		frame.getContentPane().add(roomDesc);
		labels.add(roomDesc);
		orderController.setDesc(roomDesc, 0);

		priceBtn.addActionListener((ActionEvent arg0) -> {
			checkPrice();
		});
		
		orderNow.addActionListener((ActionEvent arg0) -> {
			placeOrder();
		});
		
		roomTypeCombo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	orderController.setDesc(roomDesc, roomTypeCombo.getSelectedIndex());
		    }
		});
	}
	
	private void checkPrice() {
//if 2 days added
		if(orderController.insertedDate(startMonth.getSelectedIndex(), startDay.getSelectedIndex(), startYear.getSelectedIndex()) &&
				orderController.insertedDate(endMonth.getSelectedIndex(), endMonth.getSelectedIndex(), endMonth.getSelectedIndex())) {
			totalPrice.setText(orderController.checkPrice(String.valueOf(startDay.getSelectedIndex()), String.valueOf(startMonth.getSelectedIndex()), String.valueOf(2019 + startYear.getSelectedIndex()),
					String.valueOf(endDay.getSelectedIndex()), String.valueOf(endMonth.getSelectedIndex()), String.valueOf(2019 + endYear.getSelectedIndex()), roomTypeCombo.getSelectedIndex()));
		}
	}
	
	private boolean placeOrder() {
		boolean flag = true;
		cardError.setForeground(Color.red);
//VALID CARD
		if(orderController.validCardNum(cardNameField.getText(), cvcField.getText(), cardMonth.getSelectedIndex(), 19 + cardYear.getSelectedIndex(), cardError) == false) {
			flag = false;
			cardError.setText("Invalid Card!");
		}
		else
			cardError.setText("");
//INSERT DATE
		if(orderController.insertedDate(startMonth.getSelectedIndex(), startDay.getSelectedIndex(), startYear.getSelectedIndex()) == false ||
				orderController.insertedDate(endMonth.getSelectedIndex(), endMonth.getSelectedIndex(), endMonth.getSelectedIndex()) == false)
			endDateError.setText("Enter dates");
		if(orderController.checkDate(startDay.getSelectedIndex(), startMonth.getSelectedIndex(), startYear.getSelectedIndex(), startDateError) == false)
			flag = false;
		if(orderController.checkDate(endDay.getSelectedIndex(), endMonth.getSelectedIndex(), endYear.getSelectedIndex(), endDateError) == false)
			flag = false;
		if(flag)
			if(orderController.priceOrderCheck(flag,String.valueOf(startDay.getSelectedIndex()), String.valueOf(startMonth.getSelectedIndex()), String.valueOf(2019 + startYear.getSelectedIndex()),
					String.valueOf(endDay.getSelectedIndex()), String.valueOf(endMonth.getSelectedIndex()), String.valueOf(2019 + endYear.getSelectedIndex()), totalPrice, roomTypeCombo.getSelectedIndex(), roomTypeError, startDateError, endDateError, checkError)) {
				JOptionPane.showMessageDialog(null, "Your order have placed!"); // CREATES MASSAGE
			}
		return flag;
	}
}