package by.company.library.command;

import by.company.library.command.exception.CommandException;

public interface Command {

	String execute(String request) throws CommandException;
}
