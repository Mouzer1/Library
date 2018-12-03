package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class RejectBookingImpl implements BaseAction{
	
	BookingService bookingService = new BookingServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		int bookingId = Integer.parseInt(request.getParameter("booking_id"));
		bookingService.rejectBooking(bookingId);
		return "/admin.jsp";
	}

}
