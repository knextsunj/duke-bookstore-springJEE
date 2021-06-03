package jakarta.tutorial.dukesbookstore.ejb;

import java.util.List;

import javax.ejb.Local;

import jakarta.tutorial.dukesbookstore.dto.ShoppingCartDTO;
import jakarta.tutorial.dukesbookstore.entity.Book;
import jakarta.tutorial.dukesbookstore.exception.BookNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.BooksNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.OrderException;

@Local
public interface BookRequestLocal {

	void createBook(String bookId, String surname, String firstname, String title, Double price, Boolean onsale,
			Integer calendarYear, String description, Integer inventory);

	List<Book> getBooks() throws BooksNotFoundException;

	Book getBook(String bookId) throws BookNotFoundException;

	void updateInventory(ShoppingCartDTO cart) throws OrderException;
}
