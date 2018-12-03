package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Booking;
import by.bsuir.library.bean.Order;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.OrderService;
import by.bsuir.library.service.impl.OrderServiceImpl;

public class ShowActiveOrders implements BaseAction{
	
	OrderService orderService = new OrderServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		List<Order> orders = orderService.getAllActiveOrders();
		request.setAttribute("showActiveOrders", orders);
		return "/activeOrders.jsp";
	}

}
