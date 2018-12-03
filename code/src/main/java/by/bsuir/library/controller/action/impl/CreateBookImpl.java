package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Author;
import by.bsuir.library.bean.Book;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.service.AuthorService;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.impl.AuthorServiceImpl;
import by.bsuir.library.service.impl.BookServiceImpl;

public class CreateBookImpl implements BaseAction{

	    private BookService bookService = new BookServiceImpl();
	    private AuthorService authorService = new AuthorServiceImpl();
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String title = request.getParameter("createTitle");
		String authorName = request.getParameter("createAuthorId");
		int amount = Integer.parseInt(request.getParameter("createAmount"));
		//System.out.println("TITLE: " + title + " AUTHOR: "+ authorName + " AMOUNT: " + amount);
		int authorId = 0;
		Book book = new Book(title, authorName, amount);
		Author author = authorService.getAuthor(authorName);
		if(author == null) {
			authorService.createAuthor(new Author(authorName, "14011999"));
			authorId = authorService.getAuthorId(authorName);
			book.setAuthorId(authorId);
		}else {
			book.setAuthorId(author.getId());
		}
		bookService.createBook(book);
		return PAGE_ADMIN_MAIN;
	}

}
