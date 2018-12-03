package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Booking;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class ShowActiveBookingsImpl implements BaseAction{
	
	BookingService bookingService = new BookingServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		List<Booking> bookings = bookingService.getActiveBookings();
		request.setAttribute("showActiveBookings", bookings);
		return "/activeBookings.jsp";
	}

}
