package by.company.library.main;
import by.company.library.bean.Book;
import by.company.library.bean.Category;
import by.company.library.bean.User;
import by.company.library.command.CommandName;
import by.company.library.command.exception.CommandException;
import by.company.library.controller.Controller;
import by.company.library.dao.BookDao;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) throws DAOException, ServiceException, CommandException {

		
//		ServiceFactory serviceFactory = ServiceFactory.getInstance();
	//	UserService clientService = serviceFactory.getUserService();
	//	User u1 = clientService.registerUser(1900, "eee", "rrr");
	//	User u2 = clientService.registerUser(2005, "j", "fd");
	//	boolean a = clientService.setCategory(u1, u2);
	//	System.out.println(a);
	//	System.out.println(u1.getCategory() + " " + u2.getCategory()); 
	//	"REGISTRATION 23.04.1980 jjj iii"
	//	registration 20.01.2018 vbv kkk
	//	add_book BookChild junior
//23.04.2015 jjj k
		
		User user = new User("vbv", "kkk");
		Book book = new Book("bbb", Category.JUNIOR);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookService = serviceFactory.getUpdateLiraryService();
	//	boolean resp = bookService.takeBook("bbb", user);
		Controller cont = new Controller();
	//	String resp = cont.doAction("add_book bbb junior");
		String resp = cont.doAction("set_category vbv kkk fff jgj");
	//	boolean b = book.getCategory().equals(Category.JUNIOR);
		
	//	DAOFactory daoFactoryObject = DAOFactory.getInstance();
	//	BookDao bookDao = daoFactoryObject.getBookDAO();
		
	//	Book tb = bookDao.takeBook("bbb");
		
	//	Category.valueOf(book.getCategory());
		System.out.println(resp); 
	}		
}
