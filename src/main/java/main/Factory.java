package main;

import dao.AuthorDAO;
import dao.BookAuthorDAO;
import dao.BookDAO;
import dao.impl.AuthorDAOImpl;
import dao.impl.BookDAOImpl;
import dao.impl.BookAuthorDAOImpl;

public class Factory {
	
	public static Factory instance = new Factory();
	
	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	private BookAuthorDAO bookAuthorDAO;
	
	private Factory (){}
	
	public static Factory getInstance (){
		return Factory.instance;
	}
	
	public BookDAO getBookDAO (){
		if (bookDAO == null) bookDAO = new BookDAOImpl();
		return bookDAO;
	}

	public AuthorDAO getAuthorDAO(){
		if (authorDAO == null) authorDAO = new AuthorDAOImpl();
		return authorDAO;
	}

	public BookAuthorDAO getBookAuthorDAO () {
		if (bookAuthorDAO == null) bookAuthorDAO = new BookAuthorDAOImpl();
		return bookAuthorDAO;
	}

}
