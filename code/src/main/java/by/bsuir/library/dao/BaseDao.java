package by.bsuir.library.dao;

import by.bsuir.library.bean.Entity;

public interface BaseDao<T extends Entity> {
	
	void create (T t);
	T read(int id);
	void update(T t);
	void delete(int id);

}
