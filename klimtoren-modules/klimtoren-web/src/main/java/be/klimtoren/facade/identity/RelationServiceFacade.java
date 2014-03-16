package be.klimtoren.facade.identity;

import java.util.List;

import be.klimtoren.domain.model.party.PartyToPartyRelationship;

public interface RelationServiceFacade {
	List<PartyToPartyRelationship> findAllMarriedCouples();
	
}
