package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.impl.BookServiceImpl;

public class ShowBookListImpl implements BaseAction{

	private BookService bookService = new BookServiceImpl();
	
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String login = request.getParameter("user_login");
		System.out.println("NAAAAAME: " + login);
		List<Book> bookList = bookService.getBookCatalog();
		request.setAttribute(REQUEST_PARAM_SHOW_BOOK_LIST, bookList);
		request.setAttribute("user_login", login);
		return PAGE_USER_SHOW_BOOK_LIST;
	}

}
