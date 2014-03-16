package be.klimtoren.facade.identity;

import java.util.List;

import be.klimtoren.domain.model.party.Person;

public interface PersonServiceFacade {
	List<Person> list();
	Person find(Long id);
	Person store(Person person);
	
}
