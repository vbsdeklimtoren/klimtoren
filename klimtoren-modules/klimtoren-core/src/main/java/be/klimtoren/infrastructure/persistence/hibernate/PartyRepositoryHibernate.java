package be.klimtoren.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import be.klimtoren.domain.model.party.FullName;
import be.klimtoren.domain.model.party.Organization;
import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.party.PartyRepository;
import be.klimtoren.domain.model.party.PartyToPartyRelationship;
import be.klimtoren.domain.model.party.Person;

@Repository("partyRepository")
public class PartyRepositoryHibernate extends HibernateRepository implements PartyRepository {

	@Override
	public Party find(Long id) {
		return (Party)getSession().createQuery("from Party where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> findAllPersons() {
		String query = "select person from Person as person "
				+ "left join fetch person.names as names "
				+ "where names.endDate is null";

		return (List<Person>)getSession().createQuery(query)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Person> searchPersonByName(String partOfName) {
		String query = "select person from Person as person "
				+ "where person.displayName like :partOfName";
		return (List<Person>)getSession().createQuery(query)
				.setParameter("partOfName", "%" + partOfName + "%")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Organization> searchOrganizationByName(String partOfName) {
		String query = "select org from Organization as org "
				+ "where org.displayName like :partOfName";
		return (List<Organization>)getSession().createQuery(query)
				.setParameter("partOfName", "%" + partOfName + "%")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<PartyToPartyRelationship> findP2PByContext(Party context) {
		String query = "select p2p from PartyToPartyRelationship p2p "
				+ "inner join fetch p2p.contextParty as context "
				+ "left join fetch p2p.referencedParty as reference "
				+ "where context.id = :context";
		return (List<PartyToPartyRelationship>)getSession().createQuery(query)
				.setParameter("context", context.getId())
				.list();
	}
	@SuppressWarnings("unchecked")
	public List<PartyToPartyRelationship> findP2PByKind(String kind) {
		String query = "select p2p.id, p2p.start, p2p.end, context.id, context.displayName, reference.id, reference.displayName "
				+ "from PartyToPartyRelationship as p2p "
				+ "join p2p.kind as kind "
				+ "join p2p.contextParty as context "
				+ "join p2p.referencedParty as reference "
				+ "where kind.name = :kindName";

		Assembler ass = new Assembler();
		return ass.toP2PList(getSession().createQuery(query)
				.setParameter("kindName", kind)
				.list());
	}



	@Override
	public void store(Party party) {
		getSession().saveOrUpdate(party);
	}

	@Override
	public void storeFullName(FullName fullname) {
		getSession().saveOrUpdate(fullname);
	}

	@Override
	public void storeP2P(PartyToPartyRelationship p2p) {
		getSession().saveOrUpdate(p2p);
	}




	public static class Assembler {
		public PartyToPartyRelationship toP2P(Object[] row) {
			PartyToPartyRelationship p2p = new PartyToPartyRelationship();
			p2p.setId((Long)row[0]);
			p2p.setStart((Date)row[1]);
			p2p.setEnd((Date)row[2]);

			Party context = new Party();
			context.setId((Long)row[3]);
			context.setDisplayName((String)row[4]);

			Party reference = new Party();
			reference.setId((Long)row[5]);
			reference.setDisplayName((String)row[6]);

			p2p.setContextParty(context);
			p2p.setReferencedParty(reference);
			return p2p;
		}
		public List<PartyToPartyRelationship> toP2PList(List<Object[]> results) {
			List<PartyToPartyRelationship> list = new ArrayList<PartyToPartyRelationship>();
			for(Object[] row : results) {
				list.add(toP2P(row));
			}
			return list;
		}
	}
}