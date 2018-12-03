package by.bsuir.library.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.UserSingle;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.dao.BookingDao;
import by.bsuir.library.dao.impl.BookingDaoMySqlImpl;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookServiceImpl;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class BookBookImpl implements BaseAction{
	
	private BookingService bookingService = new BookingServiceImpl();
	private BookService bookService = new BookServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String page = "";
		UserSingle singleton = UserSingle.getUser();
		System.out.println("USER ID: " + singleton.id);
		if(bookingService.isBookingAvailable(singleton.id) == true) {
			int bookId = Integer.parseInt(request.getParameter("book_id"));
			bookingService.createBooking(singleton.id, bookId);
			bookService.decrementBook(bookId);
			page = "/user.jsp";
		}else {
			System.out.println("BBBBBBBBBBB");
			page = "/ErrorBooking.jsp";
		}
		return page;
	}

}
