package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(5L, BigDecimal.valueOf(40));
		other = new Order(5L, BigDecimal.valueOf(40));
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderIdNotEqual() {
		other.setOrderId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullId() {
		order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullTotalValue() {
		order.setTotalValue(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullTotalValueOnBoth() {
		order.setTotalValue(null);
		other.setTotalValue(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherTotalValueDifferent() {
		other.setTotalValue(BigDecimal.valueOf(20));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order(5L, BigDecimal.valueOf(40));
		assertNull(order.getOrderId());
		assertNotNull(order.getTotalValue());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null);
		Order other = new Order(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
			String toString = "ID: null || Customer ID: 5 || Total Value: 40 Gold";
		assertEquals(toString, order.toString());
	}
}