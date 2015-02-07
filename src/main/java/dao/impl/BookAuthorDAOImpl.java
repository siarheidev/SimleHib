package dao.impl;

import dao.BookAuthorDAO;
import org.hibernate.Session;
import table.BookAuthors;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class BookAuthorDAOImpl implements BookAuthorDAO {

    public void addBookAuthors(BookAuthors bookAuthors) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bookAuthors);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public List<BookAuthors> getBookAuthors() throws SQLException {
        List <BookAuthors> result = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createCriteria(BookAuthors.class).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return result;
    }
}
