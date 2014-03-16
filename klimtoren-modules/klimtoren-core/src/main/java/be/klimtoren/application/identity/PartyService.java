package be.klimtoren.application.identity;

import java.util.Date;

import be.klimtoren.domain.model.party.Organization;
import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.party.PartyToPartyRelationship;
import be.klimtoren.domain.model.party.Person;

public interface PartyService {
	Person registerNewPerson(String givenName, String surName, String middleName);
	
	Organization registerNewOrganization(String name);
	Organization registerNewOrganization(String name, Party parent);

	PartyToPartyRelationship registerRelation(Party context, Party reference,
			String kind);
	PartyToPartyRelationship registerRelation(Party context, Party reference,
			String kind, Date startDate);

	PartyToPartyRelationship changeStartDateInRelation(PartyToPartyRelationship p2p, Date startDate);
//	PartyToPartyRelationship stopRelation(Long id);
	PartyToPartyRelationship stopRelation(PartyToPartyRelationship p2p);
}
