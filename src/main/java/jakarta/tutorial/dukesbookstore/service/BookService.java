package jakarta.tutorial.dukesbookstore.service;

import java.util.List;

import jakarta.tutorial.dukesbookstore.dto.BookDTO;
import jakarta.tutorial.dukesbookstore.dto.ShoppingCartDTO;
import jakarta.tutorial.dukesbookstore.exception.BookNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.BooksNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.OrderException;

public interface BookService {

	List<BookDTO> getBooks() throws BooksNotFoundException;

	BookDTO getBook(String bookId) throws BookNotFoundException;

	void updateInventory(ShoppingCartDTO shoppingCartDTO) throws OrderException;

}
