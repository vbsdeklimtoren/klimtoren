package be.klimtoren.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.resource.Book;
import be.klimtoren.domain.model.resource.PartyResource;
import be.klimtoren.domain.model.resource.Resource;
import be.klimtoren.domain.model.resource.ResourceRepository;

@Repository("resourceRepository")
public class ResourceRepositoryHibernate extends HibernateRepository implements ResourceRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Resource> findResourcesByOwner(Party owner) {
		String sq = "select r.id, r.displayName from Resource as r join r.forParty as p where p.id = :ownerId";
		Query query = getSession().createQuery(sq).setParameter("ownerId", owner.getId());
		
		Assembler assembler = new Assembler();
		
		return assembler.fromBasicToList((List<Object[]>)query.list());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findBooksByOwner(Party owner) {
		String sq = "select b.id, b.title, pub.id, pub.displayName, auth.id, auth.displayName "
				+ "from Book as b "
				+ "join b.publisher as pub "
				+ "join b.author as auth "
				+ "join b.forParty as p where p.id = :ownerId";
		Query query = getSession().createQuery(sq).setParameter("ownerId", owner.getId());
		
		Assembler assembler = new Assembler();
		
		return assembler.fromBasicBookToList((List<Object[]>)query.list());
	}

	@Override
	public Resource store(Resource resource) {
		getSession().saveOrUpdate(resource);
		return resource;
	}

	@Override
	public PartyResource store(PartyResource partyResource) {
		getSession().saveOrUpdate(partyResource);
		return partyResource;
	}
	
	
	public static class Assembler {
		public List<Resource> fromBasicToList(List<Object[]> results) {
			List<Resource> list = new ArrayList<Resource>();
			for(Object[] row : results) {
				list.add(fromBasic(row));
			}
			return list;
		}
		
		public List<Book> fromBasicBookToList(List<Object[]> results) {
			List<Book> list = new ArrayList<Book>();
			for(Object[] row : results) {
				list.add(fromBasicBook(row));
			}
			return list;
		}

		public Resource fromBasic(Object[] row) {
			Resource resource = new Resource();
			resource.setId((Long)row[0]);
			resource.setDisplayName((String)row[1]);
			return resource;
		}
		
		public Book fromBasicBook(Object[] row) {
			Book book = new Book();
			book.setId((Long)row[0]);
			book.setTitle((String)row[1]);
			
			Party pub = new Party();
			pub.setId((Long)row[2]);
			pub.setDisplayName((String)row[3]);
			
			Party auth = new Party();
			auth.setId((Long)row[4]);
			auth.setDisplayName((String)row[5]);
			
			book.setPublisher(pub);
			book.setAuthor(auth);
			
			return book;
		}
	}

}
