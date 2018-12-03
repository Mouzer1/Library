package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookServiceImpl;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class DeleteBookImpl implements BaseAction{

	   private BookService bookService = new BookServiceImpl();
	   private BookingService bookingService = new BookingServiceImpl();
	
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
	
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		if(bookingService.checkIfBookIsFree(bookId) == true) {
			bookService.deleteBook(bookId);
		}		
		return PAGE_ADMIN_MAIN;
	}

}
