package by.bsuir.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.library.bean.Book;
import by.bsuir.library.dao.BookDao;

public class BookDaoMySqlImpl extends AbstractDaoMySqlImpl implements BookDao{
	
	private static final String SQL_BOOK_INSERT = "insert into book(title, amount, authorId) values (?, ?, ?)";
	private static final String SQL_BOOK_SELECT_ID = "select title from library where id= ?";
	private static final String SQL_BOOK_UPDATE = "UPDATE library SET title = ?, year = ?, author = ? where id = ?";
	private static final String SQL_BOOK_DECREMENT = "UPDATE book SET amount = amount - 1 WHERE id = ?";
	private static final String SQL_BOOK_INCREMENT = "UPDATE book SET amount = amount + 1 WHERE id = ?";
	private static final String SQL_BOOK_DELETE = "DELETE FROM book WHERE id = ?";
	private static final String SQL_BOOK_SELECT_ALL_USER = "SELECT librarydb.book.id, librarydb.book.title, librarydb.author.name \r\n" + 
			"FROM librarydb.book\r\n" + 
			"INNER JOIN librarydb.author\r\n" + 
			"ON librarydb.book.authorId = librarydb.author.id\r\n" + 
			"WHERE librarydb.book.amount > 0"; 
	private static final String SQL_BOOK_SELECT_BY_TITLEE = "select * from library where title = ?";
	private static final String SQL_BOOK_SELECT_BY_TITLE = "SELECT librarydb.book.id, librarydb.book.title, librarydb.author.name \r\n" + 
			"FROM librarydb.book\r\n" + 
			"INNER JOIN librarydb.author \r\n" + 
			"ON librarydb.book.authorId = librarydb.author.id \r\n" + 
			"WHERE POSITION(? in librarydb.book.title ) > 0\r\n" + 
			"AND librarydb.book.amount > 0\r\n" + 
			"UNION\r\n" + 
			"SELECT librarydb.book.id, librarydb.book.title, librarydb.author.name\r\n" + 
			"FROM librarydb.book\r\n" + 
			"INNER JOIN librarydb.author \r\n" + 
			"ON librarydb.book.authorId = librarydb.author.id \r\n" + 
			"WHERE librarydb.book.amount > 0\r\n" + 
			"AND librarydb.book.authorId = (SELECT librarydb.author.id \r\n" + 
			"							   FROM librarydb.author\r\n" + 
			"							   WHERE POSITION(? in librarydb.author.name) > 0)";
	protected Connection con;

	@Override
	public void create(Book book) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOK_INSERT);
			ps.setString(1, book.getName());
			ps.setInt(2,  book.getAmount());
			ps.setInt(3,  book.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!= null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public Book read(int id) {
		Book book = new Book();
//		try {
//			con = wcn.getConnection();
//			PreparedStatement ps = con.prepareStatement(SQL_BOOK_SELECT_ID);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				book.setTitle(rs.getString(SQL_BOOK_TITLE));
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(con != null) {
//				try {
//					con.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return book;
	}
	
	@Override
	public List<Book> readByTitle(String title) {
		List<Book> foundBooks = new ArrayList<>();
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOK_SELECT_BY_TITLE);
			ps.setString(1, title);
			ps.setString(2, title);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				foundBooks.add(createBook(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundBooks;
	}

	@Override
	public void update(Book book) {
//		try {
//			con = wcn.getConnection();
//			PreparedStatement ps = con.prepareStatement(SQL_BOOK_UPDATE);
//			ps.setString(1, book.getTitle());
//			ps.setInt(2,  book.getYear());
//			ps.setString(3,  book.getAuthor());
//			ps.setInt(4,  book.getId());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
	}

	@Override
	public void delete(int id) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOK_DELETE);
			ps.setInt(1,  id);
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
	
	public Book createBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(SQL_ID));
		book.setName(rs.getString(SQL_BOOK_TITLE));
		book.setAuthor(rs.getString(SQL_BOOK_AUTHOR));
		System.out.println("AUTHOR IS: " + book.getAuthor());
		return book;
	}

	@Override
	public List<Book> readAll() {
		List<Book> books = new ArrayList<>();
		try {
			con = wcn.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_BOOK_SELECT_ALL_USER);
			while(rs.next()) {
				books.add(createBook(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}
	
	@Override
	public void decrementBookAmount(int bookId) {
		try {
		con = wcn.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_BOOK_DECREMENT);
		ps.setInt(1, bookId);
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
	public void incrementBookAmount(int bookId) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_BOOK_INCREMENT);
			ps.setInt(1, bookId);
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
