package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.controller.util.RequestParamValidator;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.impl.BookServiceImpl;

public class SearchBookImpl implements BaseAction{
	
	private BookService bookService = new BookServiceImpl();
	
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String title = request.getParameter(COMMAND_BOOK_SEARCH);
		RequestParamValidator.validateSearchBook(title);
		List<Book> foundBooks = bookService.getFoundBook(title);
		if(foundBooks!= null) {
			request.setAttribute("showBookList", foundBooks);
			return PAGE_USER_FIND_BOOK;
		}
		return PAGE_USER_MAIN;
		
	}

}
