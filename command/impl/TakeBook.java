package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class TakeBook implements Command {

	@Override
	public String execute(String request) {
		String response = "Error during procedure";
		boolean result = false;
		User user = null;
		String[] requestLine = request.split(" ");

		String title = requestLine[1];
		String login = requestLine[2];
		String password = requestLine[3];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookService = serviceFactory.getUpdateLiraryService();
		UserService userService = serviceFactory.getUserService();

		try {
			user = userService.logination(login, password);
			result = bookService.takeBook(title, user);
			if (result == true) {
				response = "You may take a book";
			}
		} catch (ServiceException e) {
			response = "Error during procedure";
		}
		return response;
	}
}
