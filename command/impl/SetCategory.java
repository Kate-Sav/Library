package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class SetCategory implements Command {

	@Override
	public String execute(String request) {
		String response = "Error duiring set category procedure";
		boolean result = false;
		String[] requestLine = request.split(" ");

		String adultLogin = requestLine[1];
		String adultPassword = requestLine[2];
		String junLogin = requestLine[3];
		String junPassword = requestLine[4];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService clientService = serviceFactory.getUserService();

		try {
			User adult = clientService.logination(adultLogin, adultPassword);
			User junior = clientService.logination(junLogin, junPassword);
			result = clientService.setCategory(adult, junior);
			if (result == true) {
				response = "Category was changed successfully";
			}
		} catch (ServiceException e) {
			response = "Error duiring set category procedure";
		}
		return response;
	}

}
