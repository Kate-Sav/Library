package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.company.library.bean.Book;
import by.company.library.bean.Category;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;

public class BookDaoImpl implements BookDao {
	private static String fileBook = "Book.txt";

	@Override
	public boolean addBook(Book book) throws DAOException {
		boolean addBook = false;
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileBook);
			fw.write(book.getTitle() + " " + book.getCategory() + "\n");
			addBook = true;
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
		return addBook;
	}

	@Override
	public Book takeBook(String title) throws DAOException {
		Book book = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileBook);
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] dataEnter;
			while (line != null) {
				dataEnter = line.split(" ");
				if (dataEnter[0].equals(title)) {
					book = new Book(dataEnter[0], Category.valueOf(dataEnter[1].toUpperCase()));
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
		return book;
	}
}
