package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(7L, "Shield", BigDecimal.valueOf(40));
		other = new Item(7L, "Shield", BigDecimal.valueOf(40));
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getValue());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItemName(null);
		assertNull(item.getItemName());
		item.setValue(null);
		assertNull(item.getValue());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(7L, item.getId(), 7);
		assertEquals("Shield", item.getItemName());
		assertEquals(BigDecimal.valueOf(40), item.getValue());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItemName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItemName("Steel Sword");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItemName(null);
		other.setItemName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullValue() {
		item.setValue(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullValueOnBoth() {
		item.setValue(null);
		other.setValue(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherValueDifferent() {
		other.setValue(BigDecimal.valueOf(20));
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("Shield", BigDecimal.valueOf(40));
		assertNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getValue());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "ID: 7 || Item Name: Shield || Item Value: 40 Gold";
		assertEquals(toString, item.toString());
	}
}
