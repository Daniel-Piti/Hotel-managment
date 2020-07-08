package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	Customer c;
	
	@Before
	public void setUp() {
		c = new Customer("", "", "", "", "", true, "", 1, 1, 1);
	}
	
	@Test
	public void reservasionNotNull() {
		assertNotNull(c.reservations);
	}
	
	@Test
	public void testAddReservasion() {
		Reservation r = new Reservation("", "", 5, 212, new Date());
		c.reservations.add(r);
		int num = c.reservations.size();
		assertEquals("CANNOT ADD RESERVATION CORRECTLY", 1, num);
	}	
}
