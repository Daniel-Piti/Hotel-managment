package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import model.DarkMode;
import model.Hotel;
import model.Validation;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class Order {

	private JFrame frame;
	private Hotel hotel;
	private JTextField cardNameField;
	private JTextField cvcField;
	private int darkMode;
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
	private JButton checkBtn;
	private JLabel roomTypeError;
	
	//BUTTONS
		public ArrayList<JButton> btns = new ArrayList<JButton>();
	//JLABLES
		public ArrayList<JLabel> labels = new ArrayList<JLabel>();
		private JLabel checkError;
		
	public void orderForm(Hotel h, int dark) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order(h, dark);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Order(Hotel h, int dark) {
		hotel = h;
		darkMode = dark;
		System.out.println(hotel.toString());
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 398, 460);
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
		roomTypeTitle.setBounds(273, 180, 95, 14);
		frame.getContentPane().add(roomTypeTitle);
		labels.add(roomTypeTitle);
		
		roomTypeCombo = new JComboBox<String>();
		roomTypeCombo.setBounds(160, 180, 71, 20);
		frame.getContentPane().add(roomTypeCombo);
		
		hotelName = new JLabel("hotel name");
		hotelName.setBounds(139, 11, 168, 14);
		frame.getContentPane().add(hotelName);
		hotelName.setText("Hotel : " + hotel.getName());
		labels.add(hotelName);
		
		creditCardTitle = new JLabel("\u05DB\u05E8\u05D8\u05D9\u05E1 \u05D0\u05E9\u05E8\u05D0\u05D9");
		creditCardTitle.setBounds(143, 231, 107, 14);
		frame.getContentPane().add(creditCardTitle);
		labels.add(creditCardTitle);
		
		cardNumberTitle = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DB\u05E8\u05D8\u05D9\u05E1 :");
		cardNumberTitle.setBounds(259, 271, 113, 14);
		frame.getContentPane().add(cardNumberTitle);
		labels.add(cardNumberTitle);
		
		cvcTitle = new JLabel(": CVC");
		cvcTitle.setBounds(261, 349, 46, 14);
		frame.getContentPane().add(cvcTitle);
		labels.add(cvcTitle);
		
		dateTitle = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05EA\u05E4\u05D5\u05D2\u05D4 :");
		dateTitle.setBounds(261, 311, 107, 14);
		frame.getContentPane().add(dateTitle);
		labels.add(dateTitle);
		
		cardYear = new JComboBox<String>();
		cardYear.setBounds(163, 308, 68, 20);
		frame.getContentPane().add(cardYear);
		
		cardMonth = new JComboBox<String>();
		cardMonth.setBounds(76, 308, 71, 20);
		frame.getContentPane().add(cardMonth);
		
		cardNameField = new JTextField();
		cardNameField.setBounds(66, 268, 168, 20);
		frame.getContentPane().add(cardNameField);
		cardNameField.setColumns(10);
		
		cvcField = new JTextField();
		cvcField.setBounds(173, 346, 58, 20);
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
		roomTypeError.setBounds(160, 210, 146, 14);
		frame.getContentPane().add(roomTypeError);
		roomTypeError.setForeground(Color.red);
		
		
		int i;
		for(i = 0; i < hotel.roomTypes.size(); i++)
			roomTypeCombo.addItem(hotel.roomTypes.get(i).typeName);
		
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
		
		
		checkBtn = new JButton("Check dates");
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validDates();
			}
		});
		checkBtn.setBounds(48, 179, 89, 23);
		frame.getContentPane().add(checkBtn);
		btns.add(checkBtn);
		
		checkError = new JLabel("");
		checkError.setBounds(50, 210, 150, 14);
		frame.getContentPane().add(checkError);
		
		DarkMode d = new DarkMode();
		if(darkMode == 0)
			d.setLightMode(frame, labels, btns, null, null);
		else
			d.setDarkMode(frame, labels, btns, null, null);
	}


	public void validDates() {
		boolean flag = true;
		Validation v = new Validation();
		
		if(hotel.roomTypes.size() == 0) {
			roomTypeError.setText("no rooms avalivale");
			flag = false;
		}
		
		
//VALID DATE
		//START DATE
		if(!v.validDate(startDay.getSelectedIndex(), startMonth.getSelectedIndex(), startYear.getSelectedIndex(), startDateError))
			flag = false;
		//END DATE
		if(!v.validDate(endDay.getSelectedIndex(), endMonth.getSelectedIndex(), endYear.getSelectedIndex(), endDateError))
			flag = false;
		
//START DAY < CURRENT DATE
		//SET CURRENT DATE
		if(flag == true) {
			Date cur;
			Date startDate;
			Date endDate;
			
			LocalDateTime now = LocalDateTime.now();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			try {
				cur = sdf.parse(String.valueOf(now.getMonthValue()) +'/'+String.valueOf(now.getDayOfMonth())+'/'+String.valueOf(now.getYear()));
			    startDate = sdf.parse(String.valueOf(startMonth.getSelectedIndex()) +"/"+ String.valueOf(startDay.getSelectedIndex()) +"/"+String.valueOf(2019 + startYear.getSelectedIndex()));
			    endDate = sdf.parse(String.valueOf(endMonth.getSelectedIndex()) +"/"+ String.valueOf(endDay.getSelectedIndex()) +"/"+String.valueOf(2019 + endYear.getSelectedIndex()));
//START - CUR
			    System.out.println("cur - " + cur);
			    System.out.println("start - " + startDate);
			    long diffInMillies = startDate.getTime() - cur.getTime();
			    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;
			    System.out.println("START - CUR = " + diff);
			    if(diff < 1) {
			    	flag = false;
			    	startDateError.setText("Old date!");
			    }
			    
//END - START
			    diffInMillies = endDate.getTime() - startDate.getTime();
			    diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;
			    System.out.println("END - START = " + diff);

			    if(diff < 1) {
			    	flag = false;
			    	endDateError.setText("You picked 0 nights");
			    }
//CHECK IF AVAILABLE
				roomTypeError.setText("");
		    	checkError.setText("");
			    if(flag == true)
			    	if(hotel.roomTypes.get(roomTypeCombo.getSelectedIndex()).checkAvailable(startDate, roomTypeCombo.getSelectedIndex(), diff) == false) {
			    		flag = false;
				    	checkError.setText("Dates not avalivale!");
				    	checkError.setForeground(Color.red);
			    	}
			    	else {
				    	checkError.setText("Dates avalivale!");
			    		checkError.setForeground(Color.GREEN);
				    }
			   
			   //ORDER@#$%^^ 
			   //if(flag == true)
			    //	hotel.roomTypes.get(roomTypeCombo.getSelectedIndex()).placeOrderDates(startDate, roomTypeCombo.getSelectedIndex(), diff);
			   
			}
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		}

	}
}
