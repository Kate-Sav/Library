package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Logination implements Command {

	@Override
	public String execute(String request) {
		String response = "Invalid parameters";
		String[] requestLine = request.split(" ");
		String login = requestLine[1];
		String password = requestLine[2];
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService clientService = serviceFactory.getUserService();
		try {
			clientService.logination(login, password);
			if (clientService.logination(login, password) != null) {
				response = "Welcome";
			}
		} catch (ServiceException e) {
			response = "Error during login procedure";
		}

		return response;
	}

}
