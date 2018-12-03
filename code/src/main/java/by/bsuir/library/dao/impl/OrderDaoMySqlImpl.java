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
import by.bsuir.library.dao.OrderDao;

public class OrderDaoMySqlImpl extends AbstractDaoMySqlImpl implements OrderDao{
	
	public static final String SQL_SELECT_ORDERS = "SELECT librarydb.order.id, librarydb.order.date_take, librarydb.book.title\r\n" + 
			"FROM librarydb.order\r\n" + 
			"INNER JOIN librarydb.booking \r\n" + 
			"ON librarydb.order.booking_id = librarydb.booking.id\r\n" + 
			"INNER JOIN librarydb.book\r\n" + 
			"ON librarydb.booking.book_id = librarydb.book.id \r\n" + 
			"WHERE librarydb.order.is_returned = ?\r\n" + 
			"AND librarydb.booking.user_id = ?";
	public static final String SQL_SELECT_ACTIVE_ORDERS = "SELECT librarydb.order.id, librarydb.order.date_take, librarydb.book.title, librarydb.user.name, librarydb.user.surname\r\n" + 
			"FROM librarydb.order\r\n" + 
			"INNER JOIN librarydb.booking\r\n" + 
			"ON librarydb.order.booking_id = librarydb.booking.id\r\n" + 
			"INNER JOIN librarydb.user\r\n" + 
			"ON librarydb.booking.user_id = librarydb.user.id\r\n" + 
			"INNER JOIN librarydb.book\r\n" + 
			"ON librarydb.booking.book_id = librarydb.book.id\r\n" + 
			"WHERE librarydb.order.is_returned = 0";
	private static final String SQL_ORDER_UPDATE = "UPDATE librarydb.order SET librarydb.order.is_returned = 1 where id = ?";
	private static final String SQL_ORDER_INSERT = "INSERT INTO librarydb.order(date_take, is_returned, booking_id) values (?, ?, ?)";
	protected Connection con;

	@Override
	public void create(Order order) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_ORDER_INSERT);
			ps.setString(1, order.getDateTaking());
			ps.setInt(2, order.getIsReturned());
			ps.setInt(3, order.getBookingId());
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
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private Order createOrder(ResultSet rs) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setDateTaking(rs.getString("date_take"));
		order.setBook(rs.getString("title"));
		return order;
	}

	@Override
	public List<Order> getOrdersByUserId(int userId, int active) {
		List<Order> orders = new ArrayList<>();
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ORDERS);
			ps.setInt(1, active);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orders.add(createOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	private Order createFullOrder(ResultSet rs) throws SQLException {
		Order order = createOrder(rs);
		order.setName(rs.getString("name"));
		order.setSurname(rs.getString("surname"));
		return order;
	}

	@Override
	public List<Order> getActiveOrders() {
		List<Order> orders = new ArrayList<>();
		try {
			con = wcn.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ACTIVE_ORDERS);
			while(rs.next()) {
				orders.add(createFullOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void updateOrderClose(int orderId) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_ORDER_UPDATE);
			ps.setInt(1, orderId);
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
