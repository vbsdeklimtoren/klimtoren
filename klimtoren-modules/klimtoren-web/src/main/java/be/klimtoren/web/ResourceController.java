package be.klimtoren.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/books")
	@ResponseBody
	public List<Book> list() {
		return bookServiceFacade.list();
	}
}
