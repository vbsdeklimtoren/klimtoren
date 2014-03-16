package be.klimtoren.application.identity;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.resource.Book;

public interface ResourceService {
	Book registerNewBook(String title, Party author, Party publisher, Party forParty);
}
