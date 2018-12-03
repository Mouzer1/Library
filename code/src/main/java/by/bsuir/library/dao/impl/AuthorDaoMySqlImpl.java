package by.bsuir.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.bsuir.library.bean.Author;
import by.bsuir.library.dao.AuthorDao;

public class AuthorDaoMySqlImpl extends AbstractDaoMySqlImpl implements AuthorDao{
	
	private static final String SQL_SELECT_AUTHOR = "SELECT * FROM author WHERE name = ?";
	private static final String SQL_AUTHOR_INSERT = "insert into author(name, birth_date) values (?, ?)";
	protected Connection con;

	@Override
	public void create(Author author) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_AUTHOR_INSERT);
			ps.setString(1, author.getName());
			ps.setString(2,  "14011999");
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
	public Author read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private Author createAuthor(ResultSet rs) throws SQLException {
		Author author = new Author();
		author.setId(rs.getInt("id"));
		author.setName(rs.getString("name"));
		return author;
	}

	@Override
	public Author getAuthorByName(String name) {
		try {
			con = wcn.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_AUTHOR);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				return null;
			}else {
				rs.next();
				return createAuthor(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
