package dao;

import table.BookAuthors;

import java.sql.SQLException;
import java.util.List;

public interface BookAuthorDAO {
    public void addBookAuthors (BookAuthors bookAuthors)throws SQLException;
    public List<BookAuthors> getBookAuthors ()throws SQLException;
}
