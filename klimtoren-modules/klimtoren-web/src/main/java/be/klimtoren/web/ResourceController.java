package be.klimtoren.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.klimtoren.domain.model.resource.Book;
import be.klimtoren.domain.shared.ResponseView;
import be.klimtoren.facade.identity.BookServiceFacade;

@Controller
@RequestMapping("/identity/resources")
public class ResourceController {

	@Autowired
	private BookServiceFacade bookServiceFacade;
	
	@ResponseView(Book.BasicView.class)
	@RequestMapping(value="/books", method=RequestMethod.GET)
	@ResponseBody
	public List<Book> list() {
		//TODO: get current owner.
		return list(null);
	}
	
	@ResponseView(Book.BasicView.class)
	@RequestMapping(value="/books/of/{owner}", method=RequestMethod.GET)
	@ResponseBody
	public List<Book> list(@PathVariable Long owner) {
		return bookServiceFacade.list(owner);
	}
	
	@ResponseView(Book.FullView.class) 
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Book find(@PathVariable Long id) {
		return bookServiceFacade.find(id);
	}
	
	@ResponseView(Book.FullView.class)
	@RequestMapping(value="/books/new", method=RequestMethod.POST)
	@ResponseBody
	public Book newBook(@RequestBody Book book) {
		return bookServiceFacade.newBook(book.getTitle(), book.getAuthor().getId(), 
				book.getPublisher().getId(), book.getForParty().getId());
	}
}
