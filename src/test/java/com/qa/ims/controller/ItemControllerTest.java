package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String itemName = "Shield";
		String valueString = "40";
		Mockito.doReturn(itemName, valueString).when(itemController).getInput();
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble(valueString));
		Item item = new Item(itemName, value);
		Item savedItem = new Item(7L, "Shield", BigDecimal.valueOf(40));
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "7";
		String itemName = "Shield";
		String valueString = "40";
		Mockito.doReturn(id, itemName, valueString).when(itemController).getInput();
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble(valueString));
		Item item = new Item(7L, itemName, value);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "7";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(7L);
	}
	
}