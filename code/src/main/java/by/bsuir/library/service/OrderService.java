package by.bsuir.library.service;

import java.util.List;

import by.bsuir.library.bean.Order;

public interface OrderService {
	
	List<Order> getActiveOrders(int userId);
	List<Order> getInactiveOrders(int userId);
	List<Order> getAllActiveOrders();
	void closeOrder(int orderId);
	void createOrder(int bookId);

}
