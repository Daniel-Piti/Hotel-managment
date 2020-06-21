package model;

import javax.swing.JLabel;

public class Validation {
	public boolean validName(String s, JLabel j) {
		if(!(!s.equals("") && s.matches("^[a-zA-Z]*$"))) {
			j.setText("Invalid input");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validNotEmpty(String s, JLabel j) {
		if(s.equals("")) {
			j.setText("Can not be empty");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validID(String s, JLabel j) {
		if(!s.matches("[0-9]+") || s.length() != 9){
			j.setText("Invalid input");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validPhone(String s, JLabel j) {
		if(!(s.matches("[0-9]+") && s.length()>8 && s.length()<11)) {
			j.setText("Phonenumber is invalid");
			return false;
		}	
		j.setText("");
		return true;
	}
	
	public boolean validNumber(String s, JLabel j) {
		if(!s.matches("[0-9]+") || s.length() == 0) {
			j.setText("Not a number");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validCardNumber(String s, JLabel j) {
		if(!s.matches("[0-9]+") || s.length() < 8 || s.length() > 16) {
			j.setText("Invalid card");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validCVC(String s, JLabel j) {
		if(!s.matches("[0-9]+") || s.length() != 3) {
			j.setText("Invalid card");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validDouble(String s, JLabel j) {
		boolean numeric = true;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        
        if(numeric && s.length() != 0){
        	j.setText("");
        	return true;
        }
        j.setText("Not a valid number");
        return true;
	}
	
	public boolean validEmail(String s, JLabel j) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    if(!s.matches(regex)) {
	    	j.setText("Invalid Email");
			return false;
	    }
		j.setText("");
		return true;
	}

	public boolean validPassword(char[] s, JLabel j) {
		if(s.length < 6) {
			j.setText("Minimum 6 chars");
			return false;
		}
		j.setText("");
		return true;
	}
	
	public boolean validDate(int d, int m, int y, JLabel j) {
		if(d != 0 && m != 0 && y != 0) {
			y = 2021 - y;
			if(isValidDate(d, m, y)) {
				j.setText("");
				return true;
			}
			else {
				j.setText("Date is invalid");
				return false;
			}
		}
		j.setText("Date is invalid");
		return false;
	}

	private boolean isValidDate(int d, int m, int y) 
	{
        if (m == 2)  
            if ((((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))) 
                return (d <= 29); 
            else
                return (d <= 28); 
        if (m == 4 || m == 6 || m == 9 || m == 11) 
            return (d <= 30);   
	    return true; 
	}

}