package by.company.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.company.library.command.Command;
import by.company.library.command.CommandName;
import by.company.library.command.exception.CommandException;
import by.company.library.command.impl.AddNewBook;
import by.company.library.command.impl.Logination;
import by.company.library.command.impl.Registration;
import by.company.library.command.impl.SetCategory;
import by.company.library.command.impl.TakeBook;
import by.company.library.command.impl.WrongRequest;

final class CommandProvider {
	final private Map<CommandName, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.SET_CATEGORY, new SetCategory());
		commands.put(CommandName.ADD_BOOK, new AddNewBook());
		commands.put(CommandName.TAKE_BOOK, new TakeBook());
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) throws CommandException {
		CommandName nameOfCommand = null;
		Command command = null;
		
		try {
			nameOfCommand = CommandName.valueOf(name.toUpperCase());
			command = commands.get(nameOfCommand);
		} catch(IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.WRONG_REQUEST);
		}
		
		
		return command;
	}

}
