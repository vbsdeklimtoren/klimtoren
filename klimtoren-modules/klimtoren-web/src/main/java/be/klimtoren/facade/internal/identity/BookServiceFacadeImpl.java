package be.klimtoren.facade.internal.identity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.klimtoren.application.identity.PartyService;
import be.klimtoren.application.identity.ResourceService;
import be.klimtoren.domain.model.party.Organization;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.party.Person;
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
	public Book newBook() {
		Organization klimtoren = null;
		Organization eenhoorn = null;
		Person emile = null;
		if(partyRepository.searchOrganizationByName("VBS De Klimtoren").size() == 0) {
			klimtoren = partyService.registerNewOrganization("VBS De Klimtoren");
			eenhoorn = partyService.registerNewOrganization("De eenhoorn");
			emile = partyService.registerNewPerson("Emile", "Jadoul", null);
		} else {
			klimtoren = partyRepository.searchOrganizationByName("VBS De Klimtoren").get(0);
			eenhoorn = partyRepository.searchOrganizationByName("De eenhoorn").get(0);
			emile = partyRepository.searchPersonByName("Emile").get(0);
		}
		Book book = resourceService.registerNewBook("Knuffelkonijn", emile, eenhoorn, klimtoren);

		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> list() {
		newBook();
		Organization klimtoren = (Organization) partyRepository.searchOrganizationByName("VBS De Klimtoren").get(0);
		return (List<Book>) resourceRepository.findBooksByOwner(klimtoren);
	}
}
