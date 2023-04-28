package com.appsdeveloperblog.photoapp.orders;

public class OrderRest {

	private String orderId;
	private String productId;
	private String userId;
	private int quantity;
	private OrderStatus orderStatus;
	
	public OrderRest(String orderId, String productId, String userId, int quantity, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getProductId() {
		return productId;
	}

	public String getUserId() {
		return userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	
	
}
