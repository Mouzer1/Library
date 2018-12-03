package by.bsuir.library.service;

import java.util.List;

import by.bsuir.library.bean.User;

public interface UserService {
	
	User authorizeUser(String login, String pass);

	boolean checkRegistration(User user);
	
	List<User> getUserList();

}
