package com.qa.ims.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orderline;

@RunWith(MockitoJUnitRunner.class)
public class OrderlineServicesTest {
	
	@Mock
	private Dao<Orderline> orderlineDao;
	
	@InjectMocks
	private OrderlineServices orderlineServices;
	
	@Test
	public void orderlineServicesCreate() {
		Orderline orderline = new Orderline(5L, 5L);
		orderlineServices.create(orderline);
		Mockito.verify(orderlineDao, Mockito.times(1)).create(orderline);
	}
	
	@Test
	public void orderlineServicesRead() {
		orderlineServices.readAll();
		Mockito.verify(orderlineDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderlineServicesUpdate() {
		Orderline orderline = new Orderline(5L, 5L);
		orderlineServices.update(orderline);
		Mockito.verify(orderlineDao, Mockito.times(1)).update(orderline);
	}
	
	@Test
	public void orderlineServicesDelete() {
		orderlineServices.delete(5L);;
		Mockito.verify(orderlineDao, Mockito.times(1)).delete(5L);
	}
}