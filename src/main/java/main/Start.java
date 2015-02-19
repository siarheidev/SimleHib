package main;

import com.dev.dao.TestClasses;

//import table.Author;
//import table.Book;
//import table.BookAuthors;
import com.dev.util.HibernateUtil;


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
