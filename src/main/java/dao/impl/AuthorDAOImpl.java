package dao.impl;

import dao.AuthorDAO;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Expectations;

import table.Author;
import table.Book;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthorDAOImpl implements AuthorDAO {

    public void addAuthor(Author author) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.flush();
                session.close();
            }
        }
    }

    public void deleteAuthor(Author author) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.flush();
                session.close();
            }
        }
    }

    public Author getAuthor(int id) throws SQLException {
        Author result = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = (Author) session.get(Author.class, id);
//            System.out.println("+++++++ result " + result.getFirst_name());
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public Set <Book> getBooks(int id ){
    	Session session = null;
    	List result = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            result = session.createCriteria(Book.class).add(Restrictions.like("id", id)).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.flush();
                session.close();
            }
        }
        Set <Book> result1 = new HashSet<Book>(result);
		return  result1;
    
    }
    public List<Author> getAuthors() throws SQLException {
        List <Author> result = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createCriteria(Author.class).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.flush();
                session.close();
            }
        }
        return result;
    }
}
