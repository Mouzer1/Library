package by.bsuir.library.service.impl;

import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoMySqlImpl;
import by.bsuir.library.service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao = new BookDaoMySqlImpl();

	@Override
	public List<Book> getBookCatalog() {
		return bookDao.readAll();
	}
	
	@Override
	public List<Book> getFoundBook(String title){
		return bookDao.readByTitle(title);
	}

	@Override
	public void createBook(Book book) {
		bookDao.create(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.delete(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}
	
	@Override
	public void decrementBook(int bookId) {
		bookDao.decrementBookAmount(bookId);
	}

	@Override
	public void incrementBook(int bookId) {
		bookDao.incrementBookAmount(bookId);
		
	}

}
