package be.klimtoren.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.kind.KindRepository;
import be.klimtoren.domain.model.party.Party;

@Repository("kindRepository")
public class KindRepositoryHibernate extends HibernateRepository implements KindRepository {

	@Override
	public Kind find(Long id) {
		return (Kind)getSession().createQuery("from Kind where id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kind> findAllByOwner(Party owner) {
		return (List<Kind>)getSession().createQuery("from Kind where owner.id = :ownerId")
				.setParameter("ownerId", owner.getId())
				.list();
	}

	@Override
	public void store(Kind kind) {
		getSession().saveOrUpdate(kind);
	}

	@Override
	public Kind findByName(String name) {
		return findByName(name, false, null);
	}

	@Override
	public Kind findByName(String name, boolean create) {
		return findByName(name, create, null);
	}

	@Override
	public Kind findByName(String name, boolean create, Party owner) {
		String sq = "from Kind where name = :name";
		if(owner == null) {
			sq += " and owner is null";
		} else {
			sq += " and owner=:owner";
		}
		Query query = getSession().createQuery(sq)
				.setParameter("name", name);
		if(owner != null) query.setParameter("owner", owner);
		
		Kind result = (Kind)query.uniqueResult();
		if(result == null && create) {
			Kind newKind = new Kind(name, null, owner);
			store(newKind);
			return newKind;
		} else {
			return result;
		}
	}

}
