package by.bsuir.library.controller.action.impl;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.library.controller.action.BaseAction;

public class PrepareUpdateImpl implements BaseAction{

	public int idBook;
	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
//		idBook = Integer.parseInt(request.getParameter("book_id"));
//		request.setAttribute("idBook", idBook);
		return PAGE_ADMIN_MAIN;
	}

}
