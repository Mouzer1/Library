package by.bsuir.library.dao;

import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.bean.Booking;
import by.bsuir.library.bean.UserSingle;

public interface BookingDao extends BaseDao<Booking> {
	
	int readBookingsAmount(int id);
	List<Booking> getBookingsByUserId (int id);
	int getBookId(int id);
	boolean ifBookIsFree(int bookId);
	List<Booking> readNewBookings();
	List<Booking> readActiveBookings();
	void updateAcceptById(int id);
	void updateRejectById(int id);

}
