package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.User;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.controller.util.RequestParamValidator;
import by.bsuir.library.service.UserService;
import by.bsuir.library.service.impl.UserServiceImpl;

public class RegistrationImpl implements BaseAction{
	
	private UserService userService = new UserServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String name = request.getParameter(COMMAND_NAME);
		String surname = request.getParameter(COMMAND_SURNAME);
		String email = request.getParameter(COMMAND_EMAIL);
		String login = request.getParameter(COMMAND_LOGIN);
		//String password = request.getParameter(COMMAND_PASSWORD);
		String password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(request.getParameter(COMMAND_PASSWORD)); 
		RequestParamValidator.validateUserSignUp(name, surname, email, login, request.getParameter(COMMAND_PASSWORD));
	
		String page = "";
		User regUser = new User(name, surname, email, login, password, ROLE_USER);
		
		if(userService.checkRegistration(regUser) == true) {
			page= PAGE_INDEX;
		} else {
			page = PAGE_ERROR_REGISTRATION;
		}
		
		return page;
	}

}
