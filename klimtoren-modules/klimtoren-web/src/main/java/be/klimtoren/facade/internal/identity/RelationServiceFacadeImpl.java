package be.klimtoren.facade.internal.identity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.klimtoren.domain.model.kind.KindRepository;
import be.klimtoren.domain.model.kind.Kinds;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.party.PartyToPartyRelationship;
import be.klimtoren.facade.identity.RelationServiceFacade;

@Service("relationServiceFacade")
public class RelationServiceFacadeImpl implements RelationServiceFacade {

	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private KindRepository kindRepository;
	
	@Override
	public List<PartyToPartyRelationship> findAllMarriedCouples() {
		return partyRepository.findP2PByKind(Kinds.P2P_MARRIAGE);
	}

}
