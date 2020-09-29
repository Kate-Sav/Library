package by.company.library.service;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.service.exception.ServiceException;

public interface UpdateLibraryService {
	boolean addNewBook(Book book) throws ServiceException;
	boolean takeBook(String title, User user) throws ServiceException;
}
