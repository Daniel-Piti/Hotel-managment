package controller;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Customer;
import model.Hotel;
import model.OrderModel;
import model.Validation;

public class OrderController {
	public OrderModel orderModel;
	
	public OrderController(Hotel hotel, Customer user) {
		orderModel = new OrderModel(hotel, user);
	}
	
	public void setDesc(JLabel roomDesc, int selectedIndex) {
		orderModel.setDesc(roomDesc,selectedIndex);
	}

	public String getHotelName() {
		return orderModel.hotel.getName();
	}

	public void loadRoomTypes(JComboBox<String> roomTypeCombo) {
		orderModel.loadRooms(roomTypeCombo);
	}
	
	public boolean validCardNum(String card, String cvc, int month, int year, JLabel cardError) {
		Validation v = new Validation();
		if(month == 0 || year == 19)
			return false;
		if(v.validCardNumber(card, cardError))
			if(v.validCVC(cvc, cardError)){
				LocalDateTime now = LocalDateTime.now();
				if(now.getYear() == 2000 + year)
					if(now.getMonthValue() > month)
						return false;
					else
						return true;
				if(now.getYear() > 2000 + year)
					return false;
				else
					return true;
			}
		return false;
	}
	
	public int getDiff(Date startDate, Date endDate) {
		long diffInMillies = endDate.getTime() - startDate.getTime();
		return (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;
	}
	
	public boolean validDiff(JLabel roomTypeError, JLabel dateError, int index, Date cur, Date startDate, Date endDate) {
		boolean flag = true;
		
		if(orderModel.checkRoomTypesSize() == 0) {
			roomTypeError.setText("no rooms avalivale");
			flag = false;
		}
		
//SET CURRENT DATE
		if(flag == true) {
//START - CUR || END - START
		    if(getDiff(cur, startDate) < 1 || getDiff(startDate, endDate) < 1) {
		    	flag = false;
		    	dateError.setText("Invalid dates!");
		    }
		    else
		    	dateError.setText("");

//CHECK IF AVAILABLE
			roomTypeError.setText("");
		    if(flag == true)
		    	if(orderModel.checkAvalible(startDate, index, getDiff(startDate, endDate)) == false) {
		    		flag = false;
		    		dateError.setText("Dates not avalivale!");
		    		dateError.setForeground(Color.red);
		    	}
		   	else {
		   		dateError.setText("Dates avalivale!");
		   		dateError.setForeground(Color.GREEN);
		   	}
		}
		return flag;
	}

	public boolean placeOrder(boolean flag, String day1, String month1, String year1, String day2, String month2, String year2, JLabel totalPrice, int index, JLabel roomTypeError, JLabel endDateError) {
		try {
			LocalDateTime now = LocalDateTime.now();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date cur = sdf.parse(String.valueOf(now.getMonthValue()) +'/'+String.valueOf(now.getDayOfMonth())+'/'+String.valueOf(now.getYear()));
			Date startDate = sdf.parse(month1 +"/"+ day1 +"/" + year1);
			Date endDate = sdf.parse(month2 +"/"+ day2 +"/"+ year2);
			double price = 0;
			try {
				if(getDiff(startDate, endDate) > 0) {
					price =  getDiff(startDate, endDate) * orderModel.hotel.roomTypes.get(index).price;
				}else
					price = 0;
				totalPrice.setText(String.valueOf(price) + " $");
			}
			catch(Exception e){
			   	e.printStackTrace();
			}
			
			if(flag == true)
				if(validDiff(roomTypeError, endDateError, index, cur, startDate, endDate)) {
					int dialogResult = JOptionPane.showConfirmDialog (null, "<html>Do you accept the order ?<br>Total price : " + String.valueOf(price) +" $</html>","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						int dif = getDiff(startDate, endDate);
						orderModel.addOrder(index, startDate, dif);
						orderModel.addReservation(index, dif, startDate);
						JOptionPane.showMessageDialog(null, "Your order have placed!"); // CREATES MASSAGE
						return true;
					}
				}
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return false;
	}

	public boolean checkDateAndPrice(int day1, int month1, int year1, int day2, int month2, int year2, JLabel dateError, JLabel totalPrice, int index) {
		Validation v = new Validation();
		if(orderModel.hotel.roomTypes.size() == 0) {
			dateError.setText("no avalible rooms");
			return false;
		}
		if(v.validDate(day1, month1, year1, dateError))
			if(v.validDate(day2, month2, year2, dateError)) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date startDate = sdf.parse(month1 + "/" + day1 + "/" + year1);
					Date endDate = sdf.parse(month2 + "/" + day2 + "/" + year2);
					
					if(getDiff(startDate, endDate) > 0) {
						totalPrice.setText(String.valueOf(getDiff(startDate, endDate) * orderModel.hotel.roomTypes.get(index).price + "$"));
					}else
						totalPrice.setText("0 $");
				}
				catch(Exception e){
				   	e.printStackTrace();
				}
				return true;
			}
		dateError.setText("Enter Dates.");
		return false;
	}

}
