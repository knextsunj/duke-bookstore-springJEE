/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.tutorial.dukesbookstore.ejb.bean;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import jakarta.tutorial.dukesbookstore.dao.BookDAOLocal;
import jakarta.tutorial.dukesbookstore.dto.BookDTO;
import jakarta.tutorial.dukesbookstore.dto.ShoppingCartDTO;
import jakarta.tutorial.dukesbookstore.dto.ShoppingCartItemDTO;
import jakarta.tutorial.dukesbookstore.dto.assembler.BookDTOAssembler;
import jakarta.tutorial.dukesbookstore.ejb.BookRequestLocal;
import jakarta.tutorial.dukesbookstore.entity.Book;
import jakarta.tutorial.dukesbookstore.exception.BookNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.BooksNotFoundException;
import jakarta.tutorial.dukesbookstore.exception.OrderException;

/**
 * <p>
 * Stateful session bean for the bookstore example.
 * </p>
 */
@Stateful
@Local(BookRequestLocal.class)
@LocalBean
public class BookRequestBean implements BookRequestLocal {

//    @PersistenceContext
//    private EntityManager em;
	private static final Logger logger = Logger.getLogger("dukesbookstore.ejb.BookRequestBean");

	@EJB
	private BookDAOLocal bookDAOLocal;

	public BookRequestBean() throws Exception {
	}

	public void createBook(String bookId, String surname, String firstname, String title, Double price, Boolean onsale,
			Integer calendarYear, String description, Integer inventory) {
		try {
			Book book = new Book(Long.valueOf(bookId), surname, firstname, title, price, onsale, calendarYear,
					description, inventory);
			logger.log(Level.INFO, "Created book {0}", bookId);
//            em.persist(book);
			bookDAOLocal.save(book);
			logger.log(Level.INFO, "Persisted book {0}", bookId);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public List<Book> getBooks() throws BooksNotFoundException {
		try {
//            return (List<Book>) em.createNamedQuery("findBooks").getResultList();
			return bookDAOLocal.getBooks();
		} catch (Exception ex) {
			throw new BooksNotFoundException("Could not get books: " + ex.getMessage());
		}
	}

	public Book getBook(String bookId) throws BookNotFoundException {
//        Book requestedBook = em.find(Book.class, bookId);
		Book requestedBook = bookDAOLocal.getBook(Long.valueOf(bookId));
		if (requestedBook == null) {
			throw new BookNotFoundException("Couldn't find book: " + bookId);
		}

		return requestedBook;
	}

	private void buyBooks(ShoppingCartDTO cart) throws OrderException {
		Collection<ShoppingCartItemDTO> items = cart.getItems();
		Iterator<ShoppingCartItemDTO> i = items.iterator();
		BookDTOAssembler bookDTOAssembler = new BookDTOAssembler();

		try {
			while (i.hasNext()) {
				ShoppingCartItemDTO sci = (ShoppingCartItemDTO) i.next();
				BookDTO bookDTO = (BookDTO) sci.getItem();

				Book bd = bookDTOAssembler.buildBook(bookDTO);
				String id = bd.getBookId().toString();
				int quantity = sci.getQuantity();
				buyBook(id, quantity);
			}
		} catch (OrderException ex) {
			throw new OrderException("Commit failed: " + ex.getMessage());
		}
	}

	private void buyBook(String bookId, int quantity) throws OrderException {
		try {
//			Book requestedBook = em.find(Book.class, bookId);
			Book requestedBook = bookDAOLocal.getBook(Long.valueOf(bookId));
			if (requestedBook != null) {
				int inventory = requestedBook.getInventory();

				if ((inventory - quantity) >= 0) {
					int newInventory = inventory - quantity;
					requestedBook.setInventory(newInventory);
				} else {
					throw new OrderException("Not enough of " + bookId + " in stock to complete order.");
				}
			}
		} catch (OrderException ex) {
			throw new OrderException("Couldn't purchase book: " + bookId + ex.getMessage());
		}
	}

	public void updateInventory(ShoppingCartDTO cart) throws OrderException {
		try {
			buyBooks(cart);
		} catch (OrderException ex) {
			throw new OrderException("Inventory update failed: " + ex.getMessage());
		}
	}
}
