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
	
	public boolean checkDate(int day, int month, int year, JLabel DateError) {
		Validation v = new Validation();
		if(!v.validDate(day, month, year, DateError))
			return false;
		return true;
	}
	
	public double getPrice(Date startDate, Date endDate, int index) {
		return getDiff(startDate, endDate) * orderModel.hotel.roomTypes.get(index).price;
	}
	
	public int getDiff(Date startDate, Date endDate) {
		long diffInMillies = endDate.getTime() - startDate.getTime();
		return (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;

	}
	
	public boolean validDiff(JLabel roomTypeError, JLabel startDateError, JLabel endDateError, JLabel checkError, int index, Date cur, Date startDate, Date endDate) {
		boolean flag = true;
		
		if(orderModel.checkRoomTypesSize() == 0) {
			roomTypeError.setText("no rooms avalivale");
			flag = false;
		}
		
//SET CURRENT DATE
		if(flag == true) {
//START - CUR
		    if(getDiff(cur, startDate) < 1) {
		    	flag = false;
		    	startDateError.setText("Old date!");
		    }
//END - START
		    if(getDiff(startDate, endDate) < 1) {
		    	flag = false;
		    	endDateError.setText("You picked 0 nights");
		    }
//CHECK IF AVAILABLE
			roomTypeError.setText("");
	    	checkError.setText("");
		    if(flag == true)
		    	if(orderModel.checkAvalible(startDate, index, getDiff(startDate, endDate)) == false) {
		    		flag = false;
			    	checkError.setText("Dates not avalivale!");
			    	checkError.setForeground(Color.red);
		    	}
		   	else {
		    	checkError.setText("Dates avalivale!");
		    	checkError.setForeground(Color.GREEN);
		   	}
		}
		return flag;
	}

	public String checkPrice(String day1, String month1, String year1, String day2, String month2, String year2, int roomIndex) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = sdf.parse(month1 + "/" + day1 + "/" + year1);
			Date endDate = sdf.parse(month2 + "/" + day2 + "/" + year2);
			
			if(getDiff(startDate, endDate) > 0) {
				return String.valueOf(getPrice(startDate, endDate, roomIndex) + "$");
			}else
				return "0 $";
		}
		catch(Exception e){
		   	e.printStackTrace();
		}
		return "Error";
	}
	
	public void placeOrder(int index, Date startDate, int diff) {
		orderModel.addOrder(index, startDate, diff);
		orderModel.addReservation(index, diff, startDate);
	}
	
	public boolean insertedDate(int month, int day, int year) {
		if(day != 0 && month != 0 && year != 0)
			return true;
		return false;
	}

	public boolean priceOrderCheck(boolean flag, String day1, String month1, String year1, String day2, String month2, String year2, JLabel totalPrice, int index, JLabel roomTypeError, JLabel startDateError, JLabel endDateError, JLabel checkError) {
		try {
			LocalDateTime now = LocalDateTime.now();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date cur = sdf.parse(String.valueOf(now.getMonthValue()) +'/'+String.valueOf(now.getDayOfMonth())+'/'+String.valueOf(now.getYear()));
			Date startDate = sdf.parse(month1 +"/"+ day1 +"/" + year1);
			Date endDate = sdf.parse(month2 +"/"+ day2 +"/"+ year2);
			totalPrice.setText(checkPrice(day1, month1, year1, day2,month2, year2, index));
			
			if(flag == true)
				if(validDiff(roomTypeError, startDateError, endDateError, checkError, index, cur, startDate, endDate)) {
					int dialogResult = JOptionPane.showConfirmDialog (null, "<html>Do you accept the order ?<br>Total price : " + checkPrice(day1, month1, year1, day2,month2, year2, index) +"</html>","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						placeOrder(index,startDate, getDiff(startDate, endDate));
						return true;
					}
				}
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return false;
	}

	public void setDesc(JLabel roomDesc, int selectedIndex) {
		orderModel.setDesc(roomDesc,selectedIndex);
	}
}
