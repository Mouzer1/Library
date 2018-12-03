package by.bsuir.library.service.impl;

import java.util.List;

import by.bsuir.library.bean.User;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoMySqlImpl;
import by.bsuir.library.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = new UserDaoMySqlImpl();

	@Override
	public User authorizeUser(String login, String pass) {
		
		User user = new User(login, pass);
		return userDao.readUser(user);
	}

	@Override
	public boolean checkRegistration(User user) {
		if(userDao.readUserByLogin(user) == null) {
			userDao.create(user);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getUserList() {
		return userDao.readAll();
	}

}
