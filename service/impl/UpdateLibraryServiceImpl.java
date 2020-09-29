package by.company.library.service.impl;

import by.company.library.bean.Book;
import by.company.library.bean.Category;
import by.company.library.bean.User;
import by.company.library.dao.BookDao;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class UpdateLibraryServiceImpl implements UpdateLibraryService {

	@Override
	public boolean addNewBook(Book book) throws ServiceException {
		boolean newBook = false;
		if (book.getTitle() == null) {
			throw new ServiceException("Invalid parameters");
		}
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		BookDao bookDao = daoFactoryObject.getBookDAO();
		try {
			newBook = bookDao.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return newBook;

	}

	@Override
	public boolean takeBook(String title, User user) throws ServiceException {
		boolean takebook = false;
		Book book = null;
		if (title == null) {
			throw new ServiceException("Invalid title");
		}
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		BookDao bookDao = daoFactoryObject.getBookDAO();
		try {
			book = bookDao.takeBook(title);
			if (book.getCategory().equals(Category.JUNIOR) == true) {
				takebook = true;
			} else if (book.getCategory().equals(user.getCategory())) {
				takebook = true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return takebook;
	}

}
