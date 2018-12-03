package by.bsuir.library.controller.action.impl;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.User;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoMySqlImpl;
import by.bsuir.library.service.UserService;
import by.bsuir.library.service.impl.UserServiceImpl;

public class ShowUserListImpl implements BaseAction{

	private UserService userService = new UserServiceImpl();
	
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		List<User> users = userService.getUserList();
 		request.setAttribute("showUserList", users);
		return "/userList.jsp";
	}

}
