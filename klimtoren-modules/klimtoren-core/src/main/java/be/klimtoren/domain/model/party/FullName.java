package be.klimtoren.domain.model.party;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.Validate;
import org.codehaus.jackson.map.annotate.JsonView;
import org.hibernate.annotations.NaturalId;

import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.party.Party.BasicView;
import be.klimtoren.domain.shared.EntitySupport;

@Table(name="fullnames")
@Entity
public class FullName extends EntitySupport<FullName, Long>{
	//private static final long serialVersionUID = -838672199818144131L;
	
	@NaturalId
	@Getter @Setter
	private Date startDate;
	
	@Getter @Setter
	private Date endDate;
	
	@NaturalId
	@ManyToOne
	@Getter @Setter
	private Party forParty;
	
	@NaturalId
	@Getter @Setter	
	@JsonView(BasicView.class)
	private String givenName;
	
	@NaturalId
	@Getter @Setter
	private String middleName;
	
	@NaturalId
	@Getter @Setter
	@JsonView(BasicView.class)
	private String surName;
	
	@Getter @Setter
	private String title;
	
	@Getter @Setter
	private String nickName;
	
	@Getter @Setter
	private String pronunciation;
	
	@NaturalId
	@ManyToOne
	@Getter @Setter
	private Kind kind;
	
	/*------------------------------
	 | Contructors
	 -----------------------------*/
	public FullName() {
		
	}
	public FullName(String givenName, String surName, Date startDate, Party forParty) {
		Validate.notNull(surName, "Surname is required.");
		Validate.notNull(startDate, "Start date is required.");
		Validate.notNull(forParty, "For Party is required.");
		this.givenName = givenName;
		this.surName = surName;
		this.startDate = startDate;
		this.forParty = forParty;
	}
}
