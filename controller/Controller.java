package by.company.library.controller;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	private final char paramDel = ' ';

	public String doAction(String request) throws CommandException {
		String commandName;
		Command executionCommand;

		commandName = request.substring(0, request.indexOf(paramDel));
		executionCommand = provider.getCommand(commandName);
		String response = executionCommand.execute(request);

		return response;

	}
}
