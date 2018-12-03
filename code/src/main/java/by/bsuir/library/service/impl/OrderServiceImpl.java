package by.bsuir.library.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.bsuir.library.bean.Order;
import by.bsuir.library.dao.OrderDao;
import by.bsuir.library.dao.impl.OrderDaoMySqlImpl;
import by.bsuir.library.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderDao orderDao = new OrderDaoMySqlImpl();

	@Override
	public List<Order> getActiveOrders(int userId) {
		
		List<Order> orders = orderDao.getOrdersByUserId(userId, 0);
		return orders;
	}

	@Override
	public List<Order> getInactiveOrders(int userId) {
		List<Order> orders = orderDao.getOrdersByUserId(userId, 1);
		return orders;
	}

	@Override
	public List<Order> getAllActiveOrders() {
		return orderDao.getActiveOrders();
	}

	@Override
	public void closeOrder(int orderId) {
		orderDao.updateOrderClose(orderId);
		
	}

	@Override
	public void createOrder(int bookId) {
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMyyyy");
		Order order = new Order(formatForDateNow.format(dateNow), bookId, 0);
		orderDao.create(order);
		
	}
	
	

}
