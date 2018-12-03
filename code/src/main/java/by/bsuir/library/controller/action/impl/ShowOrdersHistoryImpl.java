package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Order;
import by.bsuir.library.bean.UserSingle;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.OrderService;
import by.bsuir.library.service.impl.OrderServiceImpl;

public class ShowOrdersHistoryImpl implements BaseAction{
	
	private OrderService orderService = new OrderServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String page = "";
		UserSingle singleton = UserSingle.getUser();
		List<Order> active = orderService.getActiveOrders(singleton.id);
		List<Order> inactive = orderService.getInactiveOrders(singleton.id);
		System.out.println("ACTIVE: ");
		for(Order item: active) {
			System.out.println(item);
		}
		System.out.println("INACTIVE:");
		for(Order item: inactive) {
			System.out.println(item);
		}
		Order order = new Order();
		request.setAttribute("showActiveOrderList", active);
		request.setAttribute("showInactiveOrderList", inactive);
		page = "/userOrdersHistory.jsp";
		return page;
	}

}
