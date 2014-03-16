package be.klimtoren.domain.model.party;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.map.annotate.JsonView;

import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.party.Party.BasicView;
import be.klimtoren.domain.model.party.Party.FullView;
import be.klimtoren.domain.shared.EntitySupport;

@Table(name="p2p")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=true)
public class PartyToPartyRelationship extends EntitySupport<PartyToPartyRelationship, Long> {
	
	@Column(nullable=false)
	@JsonView(BasicView.class)
	private Date start;
	
	@JsonView(BasicView.class)
	private Date end;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="contextParty")
	@JsonView(BasicView.class)
	private Party contextParty;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="referencedParty")
	@JsonView(BasicView.class)
	private Party referencedParty;
	
	@ManyToOne
	@JoinColumn(name="kind")
	@JsonView(FullView.class)
	private Kind kind;
	
	
}
