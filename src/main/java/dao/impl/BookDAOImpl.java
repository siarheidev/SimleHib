package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import table.Book;
import util.HibernateUtil;
import dao.BookDAO;

public class BookDAOImpl implements BookDAO {

	public void addBook(Book book) throws SQLException {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}

	public void deleteBook(Book book) throws SQLException {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(book);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}

	public Book getBook(int id) throws SQLException {
		Book result = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			result = (Book) session.load(Book.class, id);
			System.out.println(result.getDescription());
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

	public List<Book> getBooks() throws SQLException {
		List <Book> result = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			result = session.createCriteria(Book.class).list();
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
