package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);
	
	private CrudServices<Orderline> orderlineService;
	
	public OrderlineController(CrudServices<Orderline> orderlineService) {
		this.orderlineService = orderlineService;
	}
	
	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderlines = orderlineService.readAll();
		for (Orderline orderline: orderlines) {
			LOGGER.info(orderline.toString());
		}
		return orderlines;
	}

	@Override
	public Orderline create() {
		LOGGER.info("Please enter the order ID");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter item ID");
		Long itemId = Long.valueOf(getInput());
		Orderline orderline = orderlineService.create(new Orderline(orderId, itemId));
		LOGGER.info("Orderline Created");
		return orderline;
	}

	@Override
	public Orderline update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the new item ID");
		Long itemId = Long.valueOf(getInput());
		Orderline orderline = orderlineService.update(new Orderline(orderId, itemId));
		LOGGER.info("Orderline Updated");
		return orderline;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the orderline you would like to delete");
		Long orderId = Long.valueOf(getInput());
		orderlineService.delete(orderId);
		LOGGER.info("Orderline Deleted");
	}

}
