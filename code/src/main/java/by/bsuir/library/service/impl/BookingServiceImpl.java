package by.bsuir.library.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.bean.Booking;
import by.bsuir.library.bean.Order;
import by.bsuir.library.dao.BookingDao;
import by.bsuir.library.dao.impl.BookingDaoMySqlImpl;
import by.bsuir.library.service.BookingService;

public class BookingServiceImpl implements BookingService{
	
	BookingDao bookingDao = new BookingDaoMySqlImpl();

	@Override
	public List<Booking> getBookingCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getFoundBooking(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBookingAvailable(int id) {
		if(bookingDao.readBookingsAmount(id) < 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createBooking(int userId, int bookId) {
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMyyyy");
		Booking booking = new Booking(formatForDateNow.format(dateNow), userId, bookId, 3);
		bookingDao.create(booking);
		
		
	}

	@Override
	public void deleteBooking(int id) {
		bookingDao.delete(id);
	}

	@Override
	public void updateBooking(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> getBookingsByUserId(int id) {
		List<Booking> bookings = bookingDao.getBookingsByUserId(id);
		return bookings;
	}

	@Override
	public int getBookIdByBooking(int id) {
		return bookingDao.getBookId(id);
	}

	@Override
	public boolean checkIfBookIsFree(int bookId) {
		return bookingDao.ifBookIsFree(bookId);
	}

	@Override
	public List<Booking> getNewBookings() {
		return bookingDao.readNewBookings();
	}

	@Override
	public List<Booking> getActiveBookings() {
		return bookingDao.readActiveBookings();
	}

	@Override
	public void acceptBooking(int id) {
		bookingDao.updateAcceptById(id);
		
	}

	@Override
	public void rejectBooking(int id) {
		bookingDao.updateRejectById(id);
		
	}

}
