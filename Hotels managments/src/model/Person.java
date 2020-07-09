package model;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String firstName;
	protected String lastName;
	protected String phoneNumber;
	protected String email;
	protected String publicID;
	protected boolean gender;
	protected String password;
	protected MyDate bday;

	public Person(Builder builder) 
    { 
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phoneNumber = builder.phoneNumber;
		this.email = builder.email;
		this.publicID = builder.publicID;
		this.gender = builder.gender;
		this.password = builder.password;
		this.bday = builder.bday;
    } 
	public static class Builder{
		String firstName;
		String lastName;
		String phoneNumber;
		String email;
		String publicID;
		boolean gender;
		String password;
		MyDate bday;
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		private Builder() {} 
		
        public Builder withFirstname(String firstname) 
        { 
            this.firstName = firstname; 
            return this; 
        }
        
        public Builder withLastName(String lastName) 
        { 
            this.lastName = lastName; 
            return this; 
        }
        
        public Builder withPhone(String phoneNumber) 
        { 
            this.phoneNumber = phoneNumber; 
            return this; 
        }
        
        public Builder withMail(String email) 
        { 
            this.email = email; 
            return this; 
        }
        
        public Builder withPublicID(String publicID) 
        { 
            this.publicID = publicID; 
            return this; 
        }
        
        public Builder withGender(boolean gender) 
        { 
            this.gender = gender;
            return this; 
        }
        
        public Builder withPassword(String password) 
        { 
            this.password = password; 
            return this; 
        }
        
        public Builder withBday(MyDate bday) 
        { 
            this.bday = bday; 
            return this; 
        }

    	public Person build() {
    		return new Person(this);
    	}
	}
	
	public void duplicate(String firstName, String lastName, String phoneNumber,
			  String email, String ID, boolean gender,
			  String password, int d, int m, int y) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.publicID = ID;
		this.gender = gender;
		this.password = password;
		this.bday.day = d;
		this.bday.month = m;
		this.bday.year = y;
	}
	public void setFirstname(String s) {
		this.firstName = s;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phoneNumber;
	}
	public String getID() {
		return publicID;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return password;
	}
	public boolean getGender() {
		return gender;
	}
	public int getDay() {
		return bday.day;
	}
	public int getMonth() {
		return bday.month;
	}
	public int getYear() {
		return bday.year;
	}
	
	public void updateProfile(String phoneNumber, String email, String password) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
}