package com.qa.ims.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private Dao<Order> orderDao;
	
	@InjectMocks
	private OrderServices orderServices;
	
	@Test
	public void orderServicesCreate() {
		Order order = new Order(5L, BigDecimal.valueOf(40));
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void itemServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Order order = new Order(5L, BigDecimal.valueOf(40));
		orderServices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}
	
	@Test
	public void customerServicesDelete() {
		orderServices.delete(5L);;
		Mockito.verify(orderDao, Mockito.times(1)).delete(5L);
	}
}