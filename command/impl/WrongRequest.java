package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;

public class WrongRequest implements Command{
	
	
	@Override
	public String execute(String request) throws CommandException {
		String response = "Wrong request!\nAvailable requests:\n Registration\n Logination\n Set_category\n Add_book\n Take_book";
		return response;
	}

}
