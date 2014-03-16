package be.klimtoren.application.identity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.resource.Book;
import be.klimtoren.domain.model.resource.ResourceRepository;

@Service("resourceService")
@Transactional
public final class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public Book registerNewBook(String title, Party author, Party publisher, Party forParty) {
		Book book = new Book();
		book.setStart(new Date());
		book.setTitle(title);
		book.setDisplayName(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setForParty(forParty);
		
		resourceRepository.store(book);
		
		return book;
	}

}
