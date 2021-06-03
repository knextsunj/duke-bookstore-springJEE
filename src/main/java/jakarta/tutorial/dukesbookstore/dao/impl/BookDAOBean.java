package jakarta.tutorial.dukesbookstore.dao.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import jakarta.tutorial.dukesbookstore.config.ejb.DataSourceConfigBean;
import jakarta.tutorial.dukesbookstore.dao.BookDAOLocal;
import jakarta.tutorial.dukesbookstore.entity.Book;

@Stateless
@Local(BookDAOLocal.class)
@LocalBean
public class BookDAOBean implements BookDAOLocal {

	@EJB
	private DataSourceConfigBean dataSourceConfigBean;

	@Override
	public void save(Book book) {
		dataSourceConfigBean.getEntityManager().persist(book);

	}

	@Override
	public Book getBook(Long bookId) {

		return dataSourceConfigBean.getEntityManager().find(Book.class, bookId);
	}

	@Override
	public List<Book> getBooks() {
		return (List<Book>) dataSourceConfigBean.getEntityManager().createNamedQuery("findBooks").getResultList();

	}

}
