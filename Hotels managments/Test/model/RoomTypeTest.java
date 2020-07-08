package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class RoomTypeTest {
	RoomType r;
	
	@Before
	public void setUp() {
		r = new RoomType(null, 0, 0, 0, 0);
	}
	
	@Test
	public void reservasionNotNull() {
		assertNotNull(r.calender);
	}
	
	@Test
	public void testAddOrder() {
		Date mydate = new Date(); 
        mydate.setTime(15680); 
		r.calender.put(mydate, 1);
		int size = r.calender.size();
		assertEquals("WHEN ADDING NEW ORDER, NUMBERS OF ORDERS SHOULD B 1", 1, size);
	}
	
	@Test
	public void testCheckDateAvalible() {
		Date mydate = new Date(); 
        mydate.setTime(80); 
		r.calender.put(mydate, 1);
		assertTrue("CANT FIND THE DATA THAT INSERTED",r.calender.containsKey(mydate));
	}
}
