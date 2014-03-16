package be.klimtoren.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.model.party.PartyToPartyRelationship;
import be.klimtoren.domain.model.party.Person;
import be.klimtoren.domain.shared.ResponseView;
import be.klimtoren.facade.identity.PersonServiceFacade;
import be.klimtoren.facade.identity.RelationServiceFacade;

@Controller
@RequestMapping("/identity/parties")
public class PartyController {

	@Autowired
	private PersonServiceFacade personServiceFacade;
	@Autowired
	private RelationServiceFacade relationServiceFacade;
	
	@ResponseView(Party.FullView.class)
	@RequestMapping("/list")
	@ResponseBody
	public List<Person> list() {
		return personServiceFacade.list();
	}
	
	@ResponseView(Party.ProfileView.class) 
	@RequestMapping("/find/{id}")
	@ResponseBody
	public Person find(@PathVariable Long id) {
		return personServiceFacade.find(id);
	}
	
	@ResponseView(Party.BasicView.class)
	@RequestMapping("/marriages")
	@ResponseBody
	public List<PartyToPartyRelationship> marriages() {
		return relationServiceFacade.findAllMarriedCouples();
	}
}
