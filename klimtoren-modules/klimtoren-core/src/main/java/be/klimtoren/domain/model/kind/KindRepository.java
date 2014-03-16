package be.klimtoren.domain.model.kind;

import java.util.List;

import be.klimtoren.domain.model.party.Party;

public interface KindRepository {
	Kind find(Long id);
	List<Kind> findAllByOwner(Party owner);
	Kind findByName(String name);
	Kind findByName(String name, boolean create);
	Kind findByName(String name, boolean create, Party owner);
	void store(Kind kind);
}
