package by.bsuir.library.service;

import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.bean.Booking;

public interface BookingService {
	
	List<Booking> getBookingCatalog();

	List<Booking> getFoundBooking(String title);

	boolean isBookingAvailable(int id);
	
	void createBooking(int userId, int bookId);
	
	void deleteBooking(int id);
	
	void updateBooking(Book book);
	
	List<Booking> getBookingsByUserId(int id);
	
	int getBookIdByBooking (int id);
	boolean checkIfBookIsFree(int bookId);
	List<Booking> getNewBookings();
	List<Booking> getActiveBookings();
	void acceptBooking(int id);
	void rejectBooking(int id);

}
