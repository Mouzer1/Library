package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.impl.BookServiceImpl;

public class UpdateBookImpl implements BaseAction{
	
	//BookService bookService = new BookServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		//PrepareUpdateImpl prUpdate = new PrepareUpdateImpl();
//		String title = request.getParameter(COMMAND_UPDATE_TITLE);
//		String author = request.getParameter(COMMAND_UPDATE_AUTHOR);
//		int year = Integer.parseInt(request.getParameter(COMMAND_UPDATE_YEAR));
//		Book book = new Book(3, title, author, year);
//		bookService.updateBook(book);
//		List<Book> books = (List<Book>) bookService.getBookCatalog();
//		request.setAttribute(REQUEST_PARAM_BOOK_LIST, books);
 		return PAGE_ADMIN_MAIN;
	}

}
