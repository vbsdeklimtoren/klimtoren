package be.klimtoren.application.identity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.kind.KindRepository;
import be.klimtoren.domain.model.kind.Kinds;
import be.klimtoren.domain.model.party.FullName;
import be.klimtoren.domain.model.party.Organization;
import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.party.PartyToPartyRelationship;
import be.klimtoren.domain.model.party.Person;

import com.mysql.jdbc.StringUtils;

@Transactional
@Service("partyService")
public final class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private KindRepository kindRepository;

	@Override
	@Transactional
	public Person registerNewPerson(String givenName, String surName, String middleName) {
		String displayName = givenName + 
				(StringUtils.isNullOrEmpty(middleName) ? "" : " " + middleName ) +
				" " + surName;

		Kind personKind = kindRepository.findByName(Kinds.P_PERSON, true);

		Person p = new Person();
		p.setDisplayName(displayName);
		p.setPrimaryKind(personKind);
		partyRepository.store(p);

		FullName fn = new FullName(givenName, surName, new Date(), p);
		fn.setGivenName(givenName);
		fn.setSurName(surName);
		fn.setStartDate(new Date());
		fn.setForParty(p);
		p.addFullName(fn);

		FullName fn2 = new FullName(givenName + "2", surName, new Date(), p); //TODO: for test only
		fn2.setGivenName(givenName + "2");
		fn2.setSurName(surName + "2");
		fn2.setStartDate(new Date());
		fn2.setForParty(p);
		p.addFullName(fn2);

		partyRepository.storeFullName(fn);
		partyRepository.storeFullName(fn2);
		partyRepository.store(p);

		return p;
	}
	
	@Override
	@Transactional
	public Organization registerNewOrganization(String name) {
		return registerNewOrganization(name, null);
	}
	@Override
	@Transactional
	public Organization registerNewOrganization(String name, Party parent) {
		String displayName = name;
		Kind orgKind = kindRepository.findByName(Kinds.P_ORGANIZATION, true);
		
		Organization org = new Organization();
		org.setDisplayName(displayName);
		org.setPrimaryKind(orgKind);
		
		partyRepository.store(org);
		
		return org;
	}

	@Override
	@Transactional
	public PartyToPartyRelationship registerRelation(Party context, Party reference, String kind) {
		return registerRelation(context, reference, kind, new Date());
	}
	
	@Override
	@Transactional
	public PartyToPartyRelationship registerRelation(Party context, Party reference, String kind, Date startDate) {
		Kind p2pKind = kindRepository.findByName(kind, true);

		PartyToPartyRelationship p2p = new PartyToPartyRelationship();
		p2p.setStart(startDate);
		p2p.setContextParty(context);
		p2p.setReferencedParty(reference);
		p2p.setKind(p2pKind);
		partyRepository.storeP2P(p2p);

		return p2p;
	}

	@Override
	@Transactional
	public PartyToPartyRelationship changeStartDateInRelation(PartyToPartyRelationship p2p, Date startDate) {
		p2p.setStart(startDate);
		partyRepository.storeP2P(p2p);
		return p2p;
	}

	@Override
	@Transactional
	public PartyToPartyRelationship stopRelation(PartyToPartyRelationship p2p) {
		p2p.setEnd(new Date());
		partyRepository.storeP2P(p2p);
		return p2p;
	}

//	@Override
//	@Transactional
//	public PartyToPartyRelationship stopRelation(Long id) {
//		PartyToPartyRelationship p2p = partyRepository.findP2PById(id);
//		if(p2p != null)
//			return stopRelation(p2p);
//		else
//			return null;
//	}


	
}
