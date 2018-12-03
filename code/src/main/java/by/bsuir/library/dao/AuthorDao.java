package by.bsuir.library.dao;

import by.bsuir.library.bean.Author;

public interface AuthorDao extends BaseDao<Author>{
	
	Author getAuthorByName(String name);

}
