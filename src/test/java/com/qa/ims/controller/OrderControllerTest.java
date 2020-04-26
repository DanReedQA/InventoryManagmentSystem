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

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		String custIdString = "1";
		String quantString = "2";
		String totalValueString = "40";
		Mockito.doReturn(custIdString, quantString, totalValueString).when(orderController).getInput();
		Long customerId = Long.parseLong(custIdString);
		BigDecimal totalValue = BigDecimal.valueOf(Double.parseDouble(totalValueString));
		Order order = new Order(customerId, totalValue);
		Order savedOrder = new Order(5L, BigDecimal.valueOf(40));
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "5";
		String custIdString = "5";
		String totalValueString = "40";
		Mockito.doReturn(id, custIdString, totalValueString).when(orderController).getInput();
		BigDecimal totalValue = BigDecimal.valueOf(Double.parseDouble(totalValueString));
		Long customerId = Long.parseLong(custIdString);
		Order order = new Order(5L, customerId, totalValue);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "5";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(5L);
	}
	
}