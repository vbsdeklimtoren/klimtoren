package be.klimtoren.facade.identity;

import java.util.List;

import be.klimtoren.domain.model.resource.Book;

public interface BookServiceFacade {
	Book newBook();
	List<Book> list();
}
