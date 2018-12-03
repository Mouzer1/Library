package by.bsuir.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.library.bean.Booking;
import by.bsuir.library.bean.Order;
import by.bsuir.library.bean.UserSingle;
import by.bsuir.library.dao.BookingDao;

public class BookingDaoMySqlImpl extends AbstractDaoMySqlImpl implements BookingDao{
	
	private static final String SQL_BOOKING_READ_BY_USER_ID = "SELECT COUNT(*) from booking where is_approved != 0 and user_id = ?";
	private static final String SQL_BOOKING_INSERT = "INSERT into booking(date_booking, user_id, book_id, is_approved) values (?, ?, ?, ?)";
	private static final String SQL_BOOKING_DELETE = "DELETE FROM booking WHERE id = ?";
	private static final String SQL_SELECT_BOOKINGS_BY_USER_ID = "SELECT librarydb.booking.id, librarydb.booking.date_booking, librarydb.book.title\r\n" + 
			"FROM librarydb.booking\r\n" + 
			"INNER JOIN librarydb.book \r\n" + 
			"ON librarydb.booking.book_id = librarydb.book.id  \r\n" + 
			"WHERE librarydb.booking.is_approved = 1\r\n" + 
			"OR librarydb.booking.is_approved = 3\r\n" + 
			"AND librarydb.booking.user_id = ?";
	private static final String SQL_SELECT_BOOK_ID = "SELECT librarydb.booking.book_id FROM librarydb.booking WHERE librarydb.booking.id = ?";
	private static final String SQL_SELECT_CHECK = "SELECT librarydb.booking.id FROM librarydb.booking WHERE librarydb.booking.book_id = ?";
	private static final String SQL_SELECT_NEW_BOOKINGS = "SELECT librarydb.booking.id, librarydb.booking.date_booking, librarydb.book.title, librarydb.user.name, librarydb.user.surname\r\n" + 
			"FROM librarydb.booking\r\n" + 
			"INNER JOIN librarydb.user\r\n" + 
			"ON librarydb.booking.user_id = librarydb.user.id\r\n" + 
			"INNER JOIN librarydb.book\r\n" + 
			"ON librarydb.booking.book_id = librarydb.book.id\r\n" + 
			"WHERE librarydb.booking.is_approved = 3";
	private static final String SQL_SELECT_ACTIVE_BOOKINGS = "SELECT librarydb.booking.id, librarydb.booking.date_booking, librarydb.book.title, librarydb.user.name, librarydb.user.surname\r\n" + 
			"FROM librarydb.booking\r\n" + 
			"INNER JOIN librarydb.user\r\n" + 
			"ON librarydb.booking.user_id = librarydb.user.id\r\n" + 
			"INNER JOIN librarydb.book\r\n" + 
			"ON librarydb.booking.book_id = librarydb.book.id\r\n" + 
			"WHERE librarydb.booking.is_approved = 1";
	private static final String SQL_BOOKING_UPDATE = "UPDATE booking SET is_approved = 1 where id = ?";
	private static final String SQL_BOOKING_UPDATE_REJECT = "UPDATE booking SET is_approved = 0 where id = ?";
	protected Connection con;

	@Override
	public void create(Booking booking) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOKING_INSERT);
			ps.setString(1, booking.getDateBooking());
			ps.setInt(2, booking.getUserId());
			ps.setInt(3, booking.getBookId());
			ps.setInt(4, 3);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Booking read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Booking t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {

		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOKING_DELETE);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	@Override
	public int readBookingsAmount(int id) {
		int amount = 0;
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOKING_READ_BY_USER_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	private Booking createBooking(ResultSet rs) throws SQLException {
		Booking booking = new Booking();
		booking.setId(rs.getInt("id"));
		booking.setDateBooking(rs.getString("date_booking"));
		booking.setBook(rs.getString("title"));
		return booking;
	}

	@Override
	public List<Booking> getBookingsByUserId(int id) {
		List<Booking> bookings = new ArrayList<>();
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_BOOKINGS_BY_USER_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bookings.add(createBooking(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}

	@Override
	public int getBookId(int id) {
		int bookId = 0;
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_BOOK_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bookId = rs.getInt("book_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookId;
	}

	@Override
	public boolean ifBookIsFree(int bookId) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_CHECK);
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				System.out.println("TRUUUUUUE");
				return true;
			} else {
				System.out.println("FALSEEEEEEE");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private Booking createFullBooking(ResultSet rs) throws SQLException {
		Booking booking = createBooking(rs);
		booking.setName(rs.getString("name"));
		booking.setSurname(rs.getString("surname"));
		return booking;
	}

	@Override
	public List<Booking> readNewBookings() {
		List<Booking> bookings = new ArrayList<>();
		try {
			con = wcn.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_NEW_BOOKINGS);
			while(rs.next()) {
				bookings.add(createFullBooking(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}

	@Override
	public List<Booking> readActiveBookings() {
		List<Booking> bookings = new ArrayList<>();
		try {
			con = wcn.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ACTIVE_BOOKINGS);
			while(rs.next()) {
				bookings.add(createFullBooking(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}

	@Override
	public void updateAcceptById(int id) {
		try {
		con = wcn.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_BOOKING_UPDATE);
		ps.setInt(1, id);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	}

	@Override
	public void updateRejectById(int id) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOKING_UPDATE_REJECT);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


}
