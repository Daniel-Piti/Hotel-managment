package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class ValidationTest {
	Validation v;
	JLabel j;
	
	@Before
	public void setUp() {
		v = new Validation();
		j = new JLabel();
	}
	
	@Test
	public void testValidName() {
		assertFalse("VALID NAME SHOULD B RETURN FALSE",v.validName("da1da", j));
		assertTrue("VALID NAME SHOULD B RETURN FALSE",v.validName("da", j));
		assertFalse("VALID NAME SHOULD B RETURN FALSE",v.validName("", j));
	}
	
	@Test
	public void testValidNumber() {
		assertFalse("VALID NUMBER SHOULD B RETURN FALSE", v.validNumber("123j", j));
		assertTrue("VALID NUMBER SHOULD B RETURN FALSE", v.validNumber("123", j));
		assertFalse("VALID NUMBER SHOULD B RETURN FALSE", v.validNumber("", j));
	}

	@Test
	public void testValidEmail() {
		assertFalse("VALID MAIL SHOULD B RETURN FALSE", v.validEmail("123j", j));
		assertTrue("VALID MAIL SHOULD B RETURN FALSE", v.validEmail("da@da.da", j));
		assertFalse("VALID MAIL SHOULD B RETURN FALSE", v.validEmail("d@.5", j));
	}
	
	@Test
	public void testValidPassword() {
		char[] te = {'1', '2'};
		char[] te2 = {'1', '2', '2', 'g', 'a', '2'};
		char[] te3 = {'1', '2', '2', 'g', 'a', '2', '1', '2', '2', 'g', 'a', '2', '1'};
		assertFalse("VALID MAIL SHOULD B RETURN FALSE", v.validPassword(te , j));
		assertTrue("VALID MAIL SHOULD B RETURN True", v.validPassword(te2 , j));
		assertFalse("VALID MAIL SHOULD B RETURN FALSE", v.validPassword(te3 , j));
	}
	
	@Test
	public void testValidDate() {
		assertTrue("VALID DATE SHOULD B RETURN FALSE", v.validDate(2,2,2222, j));
		assertFalse("VALID DATE SHOULD B RETURN True", v.validDate(31,2,2222 , j));
		assertFalse("VALID DATE SHOULD B RETURN True", v.validDate(0,0,2222 , j));
	}
	
	@Test
	public void testValidPhone() {
		assertFalse("VALID PHONE SHOULD B RETURN True", v.validPhone("1212121212121", j));
		assertTrue("VALID PHONE SHOULD B RETURN FALSE", v.validPhone("131253123", j));
		assertFalse("VALID PHONE SHOULD B RETURN True", v.validPhone("121212g1", j));
		assertFalse("VALID PHONE SHOULD B RETURN True", v.validPhone("12", j));
	}
	
	@Test
	public void testValidCVC() {
		assertFalse("VALID CVC SHOULD B RETURN True", v.validCVC("3112", j));
		assertTrue("VALID CVC SHOULD B RETURN FALSE", v.validCVC("123", j));
		assertFalse("VALID CVC SHOULD B RETURN True", v.validCVC("1", j));
	}
	
	@Test
	public void testValidID() {
		assertFalse("VALID ID SHOULD B RETURN True", v.validID("12", j));
		assertTrue("VALID ID SHOULD B RETURN FALSE", v.validID("123123123", j));
		assertFalse("VALID ID SHOULD B RETURN True", v.validID("1213123123213123", j));
	}
}
