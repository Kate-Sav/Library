package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.bean.Category;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response = "Error during procedure";
		boolean result;
		String[] requestLine = request.split(" ");
		String title = requestLine[1];
		Book book = new Book(title, Category.valueOf(requestLine[2].toUpperCase()));
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookService = serviceFactory.getUpdateLiraryService();
		try {
			result = bookService.addNewBook(book);
			if (result == true) {
				response = "Book was added";	
			}
		} catch (ServiceException e) {
			response = "Error during procedure";
		}

		return response;
	}

}
