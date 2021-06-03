package jakarta.tutorial.dukesbookstore.config.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.tutorial.dukesbookstore.annotation.BookServiceBean;
import jakarta.tutorial.dukesbookstore.config.AppConfig;
import jakarta.tutorial.dukesbookstore.service.BookService;

@ApplicationScoped
public class AppProducer {

	private ApplicationContext applicationContext;

	@PostConstruct
	void init() {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@Produces
	@BookServiceBean
	public BookService bookService() {
		return (BookService) applicationContext.getBean("bookServiceImpl");
	}

}
