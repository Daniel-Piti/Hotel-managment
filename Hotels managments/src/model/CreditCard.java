package model;

public class CreditCard {
	private String cardNumber;
	private int cardMonth;
	private int cardYear;
	private int cvc;
	
	public CreditCard(String cardNumber, int cardMonth, int cardYear, int cvc) {
		this.cardNumber = cardNumber;
		this.cardMonth = cardMonth;
		this.cardYear = cardYear;
		this.cvc = cvc;	
	}
	
	public void hash() {};
	public CreditCard deHash() {return new CreditCard("da",1,2,3);};
}