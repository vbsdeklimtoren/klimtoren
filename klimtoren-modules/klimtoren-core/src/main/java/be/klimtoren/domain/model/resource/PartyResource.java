package be.klimtoren.domain.model.resource;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.shared.EntitySupport;

@Table(name="party_resources")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=true)
public class PartyResource extends EntitySupport<PartyResource, Long> {
	
	private Date start;
	
	private Date end;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="forParty")
	private Party forParty;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="useResource")
	private Resource useResource;
	
	@ManyToOne
	@JoinColumn(name="kind")
	private Kind kind;
}
