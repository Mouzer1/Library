package by.bsuir.library.service;

import java.util.List;

import by.bsuir.library.bean.Book;

public interface BookService {
	
	List<Book> getBookCatalog();

	List<Book> getFoundBook(String title);

	void createBook(Book book);
	
	void deleteBook(int id);
	
	void updateBook(Book book);
	
	void decrementBook(int bookId);
	
	void incrementBook(int bookId);
}
