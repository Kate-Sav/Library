package by.company.library.service;

import by.company.library.bean.User;
import by.company.library.service.exception.ServiceException;

public interface UserService {
	User registerUser(int birthDate, String login, String password) throws ServiceException;
	User logination(String login, String password) throws ServiceException;
	boolean setCategory(User userAdult, User userJunior) throws ServiceException;
}
