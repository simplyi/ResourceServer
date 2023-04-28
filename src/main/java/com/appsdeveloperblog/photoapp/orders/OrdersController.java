package com.appsdeveloperblog.photoapp.orders;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	
	@PreAuthorize("hasRole('user')")
	@GetMapping("/orders")
	public List<OrderRest> getOrders() {
		
		OrderRest order1 = new OrderRest(UUID.randomUUID().toString(),
				"product-id-1", "user-id-1", 1, OrderStatus.NEW);
		
		OrderRest order2 = new OrderRest(UUID.randomUUID().toString(),
				"product-id-2", "user-id-1", 1, OrderStatus.NEW);
		
		return Arrays.asList(order1, order2);
	}
	
	@PreAuthorize("hasRole('user')")
	@GetMapping("/test")
	public String test() {
		
		return "working...";
	}

}
