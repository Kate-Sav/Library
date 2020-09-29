package by.company.library.dao;

import by.company.library.bean.User;
import by.company.library.dao.exception.DAOException;

public interface UserDao {

	public boolean registerUser(User user) throws DAOException;
	public User logination(String login, String password) throws DAOException;
	public boolean setCategory(User user) throws DAOException;

}
