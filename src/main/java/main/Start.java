package main;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.TestClasses;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import dao.AuthorDAO;
import dao.BookAuthorDAO;
import dao.BookDAO;
import table.Author;
import table.Book;
import table.BookAuthors;
import util.HibernateUtil;


public class Start 
{
    public static void main( String[] args )
    {
        TestClasses tc = new TestClasses();
        tc.metCr();

        tc.metSave();



        HibernateUtil.closeSessionFactory();
    }


}
