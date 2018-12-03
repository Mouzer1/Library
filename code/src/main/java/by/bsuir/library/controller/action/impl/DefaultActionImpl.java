package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;

public class DefaultActionImpl implements BaseAction{

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		return PAGE_ADMIN_MAIN;
	}
	
	

}
