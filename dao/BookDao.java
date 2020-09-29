package by.company.library.dao;

import by.company.library.bean.Book;
import by.company.library.dao.exception.DAOException;

public interface BookDao {
	
	public boolean addBook(Book book) throws DAOException;
	public Book takeBook(String title) throws DAOException;

}
