package by.company.library.service.impl;

import java.util.GregorianCalendar;

import by.company.library.bean.Category;
import by.company.library.bean.User;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public User logination(String login, String password) throws ServiceException {
		User singInUser = null;
		if (login == null || password == null) {
			throw new ServiceException("Invalid parameters");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		try {
			singInUser = userDAO.logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return singInUser;
	}

	@Override
	public User registerUser(int birthDate, String login, String password) throws ServiceException {
		User newUser = null;
		if (birthDate <= 0 || login == null || password == null) {
			throw new ServiceException ("Invalid parameters");
		} 
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
			try {
				if (new GregorianCalendar().getWeekYear() - birthDate >= 18) {
					newUser = new User(login, password, Category.ADULT);
					userDAO.registerUser(newUser);
				} else {
					newUser = new User(login, password);
					userDAO.registerUser(newUser);
				}
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		return newUser;
	}

	@Override
	public boolean setCategory(User userAdult, User userJunior) throws ServiceException {
		boolean setCategory = false;
		if (userAdult.getCategory().equals(Category.JUNIOR)) {
			throw new ServiceException();
		}
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		UserDao userDao = daoFactoryObject.getUserDAO();
		try {
			userDao.setCategory(userJunior);
			setCategory = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}


		return setCategory;
	}

}
