package by.bsuir.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.library.bean.User;
import by.bsuir.library.dao.UserDao;

public class UserDaoMySqlImpl extends AbstractDaoMySqlImpl implements UserDao{
	
	private static final String SQL_INSERT_USER = "INSERT INTO user(name, surname, email, login, password, role) values ( ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_USER = "SELECT id, name, surname, email, login, password, role FROM user WHERE login = ? and password = ?";
    private static final String SQL_SELECT_USER_LOGIN = "SELECT id, name, surname, email, login, password, role FROM user WHERE login = ?";
    private static final String SQL_SELECT_USER_ALL = "SELECT id, name, surname, email, login, password, role FROM user WHERE role = 0";

    @Override
    public List<User> readAll() {

        List<User> users = new ArrayList<User>();
        try {
            Connection con = wcn.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_USER_ALL);
            while (rs.next()) {
                users.add(createUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(SQL_ID));
        user.setName(rs.getString(SQL_NAME));
        user.setSurname(rs.getString(SQL_USER_SURNAME));
        user.setEmail(rs.getString("email"));
        user.setLogin(rs.getString(SQL_USER_LOGIN));
        user.setPassword(rs.getString(SQL_USER_PASSWORD));
        user.setRole(rs.getInt(SQL_USER_ROLE));
        return user;
    }
    
    @Override
    public User readUserByLogin(User userIn) {
        User user = null;
        try {
            Connection con = wcn.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_LOGIN);
            ps.setString(1, userIn.getLogin());        
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User readUser(User userIn) {
        User user = null;
        try {
            Connection con = wcn.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER);
            ps.setString(1, userIn.getLogin());
            ps.setString(2, userIn.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {
    	try {
            Connection con = wcn.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getLogin());
            ps.setString(5, user.getPassword());
            ps.setString(6, "0");
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

}
