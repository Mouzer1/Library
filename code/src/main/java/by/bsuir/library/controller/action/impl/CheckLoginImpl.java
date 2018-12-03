package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.bean.Book;
import by.bsuir.library.bean.User;
import by.bsuir.library.bean.UserSingle;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.controller.util.RequestParamValidator;
import by.bsuir.library.service.BookService;
import by.bsuir.library.service.UserService;
import by.bsuir.library.service.impl.BookServiceImpl;
import by.bsuir.library.service.impl.UserServiceImpl;


public class CheckLoginImpl implements BaseAction{
	
	private UserService userService = new UserServiceImpl();	
	public UserSingle current;

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
			
	        String login = request.getParameter(COMMAND_LOGIN);
	        //String password = request.getParameter(COMMAND_PASSWORD);
	        String password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(request.getParameter(COMMAND_PASSWORD)); 
	        RequestParamValidator.validateUserLoginPass(login, request.getParameter(COMMAND_PASSWORD));
	        //System.out.println("Login is: " + login + " PASSWORD: " + password);
	        String page = "";
	        User user = userService.authorizeUser(login, password);
	        if (user != null){
	        	System.out.println("CURRENT USER ID: " + user.getId());
	        	current = UserSingle.getUser();
	        	current.id = user.getId();
	        	System.out.println("CURRENT SINGLETON ID: " + current.id);
	            if(user.getRole() == ROLE_ADMIN){
	                page =  PAGE_ADMIN_MAIN;
	            }else {
	            	request.setAttribute("user", user.getLogin());
	            	request.setAttribute("user_login", user.getLogin());
	                page = PAGE_USER_MAIN;
	            }
	        } else {
	        	page = PAGE_ERROR_SIGN_IN;
	        }
	        return page;
//		String login = request.getParameter(COMMAND_LOGIN);
//		String pass = request.getParameter(COMMAND_PASS);
//		RequestParamValidator.validateUserLoginPass(login, pass);
//		
//		User user = userService.authorizeUser(login, pass);
//		if(user != null) {
//			if(user.getRole().equals(USER_ROLE_ADMIN)) {
//				List<Book> books = (List<Book>) bookService.getBookCatalog();
//				request.setAttribute(REQUEST_PARAM_BOOK_LIST, books);
//				return PAGE_ADMIN_MAIN;
//			} else if(user.getRole().equals(USER_ROLE_USER)) {
//				request.setAttribute("user", user.getLogin());
//				return PAGE_USER_MAIN;
//			}
//		} else {
//			return PAGE_ERROR;
//		}
//		return null;
	}
	
	

}
