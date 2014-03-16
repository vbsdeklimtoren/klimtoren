package be.klimtoren.domain.model.resource;

import java.util.List;

import be.klimtoren.domain.model.party.Party;

public interface ResourceRepository {
	List<? extends Resource> findResourcesByOwner(Party owner);
	List<? extends Resource> findBooksByOwner(Party owner);
	
	Resource store(Resource resource);
	PartyResource store(PartyResource partyResource);
}
