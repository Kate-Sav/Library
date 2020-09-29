package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response = "Error duiring registration";
		String[] requestLine = request.split(" ");
		int birthDate = Integer.parseInt(requestLine[1].split("\\.")[2]);
		String login = requestLine[2];
		String password = requestLine[3];
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService clientService = serviceFactory.getUserService();

		try {
			clientService.registerUser(birthDate, login, password);
			if (clientService.registerUser(birthDate, login, password) != null) {
				response = "Welcome";
			}
		} catch (ServiceException e) {
			response = "Error duiring registration";
		}
		return response;
	}
}
