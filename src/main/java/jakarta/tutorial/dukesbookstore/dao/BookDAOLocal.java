package jakarta.tutorial.dukesbookstore.dao;

import java.util.List;

import javax.ejb.Local;

import jakarta.tutorial.dukesbookstore.entity.Book;

@Local
public interface BookDAOLocal {

	void save(Book book);

	Book getBook(Long bookId);

	List<Book> getBooks();
}
