package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.OrderService;
import by.bsuir.library.service.impl.BookingServiceImpl;
import by.bsuir.library.service.impl.OrderServiceImpl;

public class MakeOrderImpl implements BaseAction{
	
	OrderService orderService = new OrderServiceImpl();
	BookingService bookingService = new BookingServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		int bookingId = Integer.parseInt(request.getParameter("booking_id"));
		orderService.createOrder(bookingId);
		bookingService.rejectBooking(bookingId);
		return "/admin.jsp";
	}

}
