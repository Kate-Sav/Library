package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.company.library.bean.User;
import by.company.library.bean.Category;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao {
	private static File file = new File("User.txt");

	@Override
	public boolean registerUser(User user) throws DAOException {
		boolean newUser = false;
		FileWriter fw = null;
		try {

			fw = new FileWriter(file, true);
			fw.write(user.getLogin() + " " + user.getPassword() + " " + user.getCategory() + "\n");
			newUser = true;
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return newUser;
	}

	@Override
	public User logination(String login, String password) throws DAOException {
		User user = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] dataEnter;
			while (line != null) {
				dataEnter = line.split(" ");
				if (dataEnter[0].equals(login) && dataEnter[1].equals(password)) {
					user = new User(dataEnter[0], dataEnter[1], Category.valueOf(dataEnter[2].toUpperCase()));
					break;
				} else {
					line = br.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				br.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return user;
	}

	@Override
	public boolean setCategory(User userJunior) throws DAOException {
		boolean setCategory = false;
		File newFile = new File("tempFile");
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			fw = new FileWriter(newFile, true);
			String line = br.readLine();
			String[] dataEnter;
			while (line != null) {
				dataEnter = line.split(" ");
				if (dataEnter[0].equals(userJunior.getLogin()) && dataEnter[1].equals(userJunior.getPassword())) {
					fw.write(userJunior.getLogin() + " " + userJunior.getPassword() + " " + Category.ADULT + "\n");
					setCategory = true;
					line = br.readLine();
				} else {
					fw.write(line + "\n");
					line = br.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				br.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				fw.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}

		}
		file.delete();
		newFile.renameTo(file);
		return setCategory;
	}

}
