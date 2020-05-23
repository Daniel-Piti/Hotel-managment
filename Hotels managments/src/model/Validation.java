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
