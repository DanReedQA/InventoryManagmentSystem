package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class OrderlineTest {
	
	private Orderline orderline;
	private Orderline other;
	
	@Before
	public void setUp() {
		orderline = new Orderline(5L, 5L);
		other = new Orderline(5L, 5L);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(orderline.getOrderId());
		assertNotNull(orderline.getItemId());
		
		orderline.setOrderId(null);
		assertNull(orderline.getOrderId());
		orderline.setItemId(null);
		assertNull(orderline.getItemId());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(orderline.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderline.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(orderline.equals(orderline));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void orderlineIdNullButOtherIdNotNull() {
		orderline.setItemId(null);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void orderlineIdNotEqual() {
		other.setItemId(6L);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullId() {
		orderline.setItemId(null);
		other.setItemId(null);
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderId(2L);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(orderline.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Order ID: 5 || Item ID: 5";
		assertEquals(toString, orderline.toString());
	}
}