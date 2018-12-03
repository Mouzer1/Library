package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.dao.BookingDao;
import by.bsuir.library.dao.impl.BookingDaoMySqlImpl;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookServiceImpl;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class CancelBookingImpl implements BaseAction{
	
	BookingService bookingService = new BookingServiceImpl();
	BookService bookService = new BookServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		int bookingId = Integer.parseInt(request.getParameter("booking_id"));
		int bookId = bookingService.getBookIdByBooking(bookingId);
		bookingService.deleteBooking(bookingId);
		bookService.incrementBook(bookId);
		return "/user.jsp";
	}

}
