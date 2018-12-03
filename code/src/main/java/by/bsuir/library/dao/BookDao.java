package by.bsuir.library.dao;

import java.util.List;

import by.bsuir.library.bean.Book;

public interface BookDao extends BaseDao<Book>{
	
	List <Book> readAll();
	List<Book> readByTitle(String title);
	void decrementBookAmount(int bookId);
	void incrementBookAmount(int bookId);

}
