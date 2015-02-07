package dao;

import table.Author;
import table.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface AuthorDAO {
    public void addAuthor(Author author) throws SQLException;
    public void deleteAuthor(Author author) throws SQLException;
    public Author getAuthor(int id) throws SQLException;
    public List<Author> getAuthors() throws SQLException;
    public Set <Book> getBooks(int id );
}
