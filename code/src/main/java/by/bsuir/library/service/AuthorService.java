package by.bsuir.library.service;

import by.bsuir.library.bean.Author;

public interface AuthorService {
	
	Author getAuthor(String name);
	void createAuthor(Author author);
	int getAuthorId(String name);

}
