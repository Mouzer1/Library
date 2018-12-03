package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.OrderService;
import by.bsuir.library.service.impl.OrderServiceImpl;

public class ReturnBookImpl implements BaseAction{
	
	OrderService orderService = new OrderServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		orderService.closeOrder(orderId);
		return "/admin.jsp";
	}

}
