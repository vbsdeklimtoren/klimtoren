package be.klimtoren.facade.identity;

import java.util.List;

import be.klimtoren.domain.model.resource.Book;

public interface BookServiceFacade {
	Book newBook(String title, Long authorId, Long publisherId, Long ownerId);
	List<Book> list(Long ownerId);
	Book find(Long id);
}
