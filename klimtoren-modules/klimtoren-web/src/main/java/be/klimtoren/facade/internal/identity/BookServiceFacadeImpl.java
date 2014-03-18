package be.klimtoren.facade.internal.identity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.klimtoren.application.identity.PartyService;
import be.klimtoren.application.identity.ResourceService;
import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.resource.Book;
import be.klimtoren.domain.model.resource.ResourceRepository;
import be.klimtoren.facade.identity.BookServiceFacade;

@Service("bookServiceFacade")
@Transactional
public class BookServiceFacadeImpl implements BookServiceFacade {

	@Autowired
	private ResourceRepository resourceRepository;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private PartyService partyService;
	@Autowired
	private ResourceService resourceService;


	@Override
	public Book newBook(String title, Long authorId, Long publisherId, Long ownerId) {
		Party author = partyRepository.find(authorId);
		Party publisher = partyRepository.find(publisherId);
		Party forParty = partyRepository.find(ownerId);
		
		if(author != null && publisher != null && forParty != null) {
			return resourceService.registerNewBook(title, author, publisher, forParty);
		} else {
			return null; //TODO: throw error ??
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> list(Long ownerId) {
		Party owner = new Party();
		owner.setId(ownerId);;
		
		return (List<Book>) resourceRepository.findBooksByOwner(owner);
	}

	@Override
	public Book find(Long id) {
		return (Book) resourceRepository.findBook(id);
	}
}
