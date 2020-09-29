package by.company.library.service;

import by.company.library.service.impl.UpdateLibraryServiceImpl;
import by.company.library.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final UpdateLibraryService libraryService = new UpdateLibraryServiceImpl();
	private final UserService userService = new UserServiceImpl();
	
	private ServiceFactory() {}
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public UpdateLibraryService getUpdateLiraryService(){
		return libraryService;
	}
	
	public UserService getUserService(){
		return userService;
	}

}
