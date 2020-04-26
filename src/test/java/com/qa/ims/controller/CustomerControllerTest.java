package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void createTest() {
		String firstName = "Dan";
		String surname = "Reed";
		Mockito.doReturn(firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(firstName, surname);
		Customer savedCustomer = new Customer(7L, "Dan", "Reed");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "7";
		String firstName = "Dan";
		String surname = "Reed";
		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(7L, firstName, surname);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "7";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(7L);
	}
	
}
