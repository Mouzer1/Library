package by.bsuir.library.dao.impl;

import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.service.BookingService;
import by.bsuir.library.service.impl.BookingServiceImpl;

public class Main {

	public static void main(String[] args) {
		BookDao bookDao = new BookDaoMySqlImpl();
		List<Book> books = bookDao.readByTitle("Пушкин");
		for(Book item: books) {
			System.out.println(item);
		}
	}

}
