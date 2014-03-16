package be.klimtoren.domain.model.party;

import java.util.List;


public interface PartyRepository {
	Party find(Long id);
	
	List<Person> findAllPersons();
	List<Person> searchPersonByName(String partOfName);
	List<Organization> searchOrganizationByName(String partOfName);
	
	List<PartyToPartyRelationship> findP2PByContext(Party context);
	List<PartyToPartyRelationship> findP2PByKind(String kind);
	
	void store(Party party);
	void storeFullName(FullName fn);
	void storeP2P(PartyToPartyRelationship p2p);

	

}
