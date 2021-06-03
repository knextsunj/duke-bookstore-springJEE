package jakarta.tutorial.dukesbookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.tutorial.dukesbookstore.dto.BookDTO;
import jakarta.tutorial.dukesbookstore.dto.ShoppingCartDTO;
import jakarta.tutorial.dukesbookstore.dto.assembler.BookDTOAssembler;
import jakarta.tutorial.dukesbookstore.ejb.BookRequestLocal;
import jakarta.tutorial.dukesbookstore.entity.Book;
import jakarta.tutorial.dukesbookstore.exception.BookNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.BooksNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.OrderException;
import jakarta.tutorial.dukesbookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRequestLocal bookRequestLocal;

	@Override
	public List<BookDTO> getBooks() throws BooksNotFoundException {
		BookDTOAssembler bookDTOAssembler = new BookDTOAssembler();
		List<BookDTO> bookDTOList = new ArrayList<>();
		bookRequestLocal.getBooks().stream().forEach(book -> {
			bookDTOList.add(bookDTOAssembler.buildBookDTO(book));
		});
		return bookDTOList;
	}

	@Override
	public BookDTO getBook(String bookId) throws BookNotFoundException {
		BookDTOAssembler bookDTOAssembler = new BookDTOAssembler();
		Book book = bookRequestLocal.getBook(bookId);
		return bookDTOAssembler.buildBookDTO(book);
	}

	@Override
	public void updateInventory(ShoppingCartDTO shoppingCartDTO) throws OrderException {
		bookRequestLocal.updateInventory(shoppingCartDTO);

	}

}
