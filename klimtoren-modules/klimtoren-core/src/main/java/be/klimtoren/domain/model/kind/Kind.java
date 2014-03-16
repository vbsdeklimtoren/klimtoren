package be.klimtoren.domain.model.kind;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.Validate;
import org.hibernate.annotations.NaturalId;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.shared.EntitySupport;

@Table(name="kinds")
@Entity
public class Kind extends EntitySupport<Kind, Long> {
	
	@NaturalId
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String descriptiveInformation;
	
	@NaturalId
	@ManyToOne
	@Getter @Setter
	private Party owner;
	
	/*------------------------------
	 | Contructors
	 -----------------------------*/
	public Kind() {
	}
	public Kind(String name, String descriptiveInformation, Party owner) {
		Validate.notNull(name, "Name is required.");
		
		setName(name);
		setDescriptiveInformation(descriptiveInformation);
		setOwner(owner);
	}
	
	public Kind(Long id, String name) {
		Validate.notNull(id, "Id is required.");
		Validate.notNull(name, "Name is required.");
		
		setId(id);
		setName(name);
	}
	
}
