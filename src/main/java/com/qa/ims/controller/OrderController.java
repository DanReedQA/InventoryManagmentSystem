package com.qa.ims.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order customers: orders) {
			LOGGER.info(customers.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a CustomerID");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter the value of the item in Gold");
		BigDecimal itemValue = BigDecimal.valueOf(Double.parseDouble(getInput()));
		LOGGER.info("Please enter the quantity of the item you wish to purchase");
		BigDecimal quantity = BigDecimal.valueOf(Double.parseDouble(getInput()));
		LOGGER.info("Calculating the total cost of your order....");
		BigDecimal totalValue = (itemValue.multiply(quantity));
		Order order = orderService.create( new Order(customerId, totalValue));
		LOGGER.info("Order Created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the Customer ID of this order");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter the total value");
		BigDecimal totalValue = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Order order = orderService.update(new Order(orderId, customerId, totalValue));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long orderId = Long.valueOf(getInput());
		orderService.delete(orderId);
		LOGGER.info("Order " + orderId + " Deleted");
	}

}
