package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.REQUEST_PARAM_SHOW_BOOK_LIST;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.bean.Booking;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class ShowNewBookingsImpl implements BaseAction{
	
	BookingService bookingService = new BookingServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		List<Booking> bookings = bookingService.getNewBookings();
		request.setAttribute("showNewBookings", bookings);
		return "/NewBookings.jsp";
	}

}
