package by.bsuir.library.service.impl;

import by.bsuir.library.bean.Author;
import by.bsuir.library.dao.AuthorDao;
import by.bsuir.library.dao.impl.AuthorDaoMySqlImpl;
import by.bsuir.library.service.AuthorService;

public class AuthorServiceImpl implements AuthorService{

	AuthorDao authorDao = new AuthorDaoMySqlImpl();
	
	@Override
	public Author getAuthor(String name) {
		return authorDao.getAuthorByName(name);
	}

	@Override
	public void createAuthor(Author author) {
		authorDao.create(author);
	}

	@Override
	public int getAuthorId(String name) {
		return authorDao.getAuthorByName(name).getId();
	}
	
	

}
