package jakarta.tutorial.dukesbookstore.dto.assembler;

import jakarta.tutorial.dukesbookstore.dto.BookDTO;
import jakarta.tutorial.dukesbookstore.entity.Book;

public class BookDTOAssembler {

	public BookDTO buildBookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();

		bookDTO.setBookId(book.getBookId().toString());
		bookDTO.setCalendarYear(book.getCalendarYear());
		bookDTO.setDescription(book.getDescription());
		bookDTO.setFirstname(book.getFirstname());
		bookDTO.setInventory(book.getInventory());
		bookDTO.setOnsale(book.getOnsale());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setTitle(book.getTitle());

		return bookDTO;
	}

	public Book buildBook(BookDTO bookDTO) {
		Book book = new Book();

		book.setBookId(Long.valueOf(bookDTO.getBookId()));
		book.setCalendarYear(bookDTO.getCalendarYear());
		book.setDescription(bookDTO.getDescription());
		book.setFirstname(bookDTO.getFirstname());
		book.setInventory(bookDTO.getInventory());
		book.setOnsale(bookDTO.getOnsale());
		book.setPrice(bookDTO.getPrice());
		book.setSurname(bookDTO.getSurname());
		book.setTitle(bookDTO.getTitle());

		return book;
	}

}
