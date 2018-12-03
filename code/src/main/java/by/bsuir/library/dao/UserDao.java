package by.bsuir.library.dao;

import java.util.List;

import by.bsuir.library.bean.User;

public interface UserDao extends BaseDao<User>{
	
	List<User> readAll();
	User readUser(User user);
	User readUserByLogin(User userIn);

}
