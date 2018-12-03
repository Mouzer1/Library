package by.bsuir.library.controller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.bsuir.library.controller.RequestParamValidationException;

public class RequestParamValidator {
	
	public static final String REG_STR = "^[a-zA-ZР-пр-џ_-]{2,20}$";
	public static final String REG_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String REG_PASSWORD = "^[a-zA-Z0-9_-]{2,18}$";
	public static final String REG_LOGIN = "^[a-zA-Z0-9_-]{3,16}$";
	
	public static final String BOOK_SEARCH_STR = "^[a-zA-ZР-пр-џ_-]{0,50}$";
	
	public RequestParamValidator() {
		
	}
	
	public static void validateUserLoginPass(String login, String pass) {
		if(login == null || pass == null) {
			throw new RequestParamValidationException();
		}
	}
	
	public static void validateSearchBook (String title) {
		Pattern patternBookSearch = Pattern.compile(BOOK_SEARCH_STR);
		Matcher matcherBookSearch = patternBookSearch.matcher(title);
		if(!matcherBookSearch.matches()) {
			throw new RequestParamValidationException();
		}
		
	}
	
	public static void validateUserSignUp(String name, String surname, String email, String login, String password) {
		Pattern patternStr = Pattern.compile(REG_STR);
		Pattern patternEmail = Pattern.compile(REG_EMAIL);
		Pattern patternPassword = Pattern.compile(REG_PASSWORD);
		Pattern patternLogin = Pattern.compile(REG_LOGIN);
		
		Matcher matcherName = patternStr.matcher(name);
		Matcher matcherSurname = patternStr.matcher(surname);
		Matcher matcherEmail = patternEmail.matcher(email);
		Matcher matcherLogin = patternLogin.matcher(login);
		Matcher matcherPassword = patternPassword.matcher(password);
		
		if(!matcherName.matches() || !matcherSurname.matches() || !matcherEmail.matches() || !matcherLogin.matches() || !matcherPassword.matches()) {
			throw new RequestParamValidationException();
		}
	}

}
