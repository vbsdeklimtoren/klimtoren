package be.klimtoren.facade.internal.identity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.klimtoren.application.identity.PartyService;
import be.klimtoren.domain.model.kind.Kinds;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.party.Person;
import be.klimtoren.facade.identity.PersonServiceFacade;

@Service("personServiceFacade")
public class PersonServiceFacadeImpl implements PersonServiceFacade {

	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private PartyService partyService;


	@Override
	@Transactional
	public List<Person> list() {
		Person karl = partyService.registerNewPerson("Karl", "Van Iseghem", null);
		Person ulrike = partyService.registerNewPerson("Ulrike", "Drieskens", null);

		partyService.registerRelation(karl, ulrike, Kinds.P2P_MARRIAGE);
		
		List<Person> personList = partyRepository.findAllPersons();
		return personList;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Person find(Long id) {
		return (Person)partyRepository.find(id);
	}

	@Override
	public Person store(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
