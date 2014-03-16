package be.klimtoren.domain.model.resource;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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

@Table(name="resources")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=true)
public class Resource extends EntitySupport<Resource, Long> {
	
	private Date start;
	
	private Date end;
	
	private String displayName;
	
	private String descriptiveInformation;
	
	@ManyToOne
	@JoinColumn(name="forParty")
	private Party forParty;
	
	@ManyToOne
	@JoinColumn(name="kind")
	private Kind kind;
	
	@ManyToOne
	@JoinColumn(name="parent")
	private Resource parent;
}
