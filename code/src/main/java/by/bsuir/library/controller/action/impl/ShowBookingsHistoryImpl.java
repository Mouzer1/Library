package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Booking;
import by.bsuir.library.bean.UserSingle;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.OrderService;
import by.bsuir.library.service.impl.BookingServiceImpl;
import by.bsuir.library.service.impl.OrderServiceImpl;

public class ShowBookingsHistoryImpl implements BaseAction{
	
	private BookingService bookingService = new BookingServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		UserSingle singleton = UserSingle.getUser();
		List<Booking> bookings = bookingService.getBookingsByUserId(singleton.id);
		request.setAttribute("showBookings", bookings);
		return "/userBookingsHistory.jsp";
	}

}
