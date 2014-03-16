package be.klimtoren.domain.model.resource;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonView;

import be.klimtoren.domain.model.party.Party;
import be.klimtoren.domain.shared.BaseView;
import lombok.Getter;
import lombok.Setter;

@Table(name="books")
@Entity
@PrimaryKeyJoinColumn(name="resource_id")
public class Book extends Resource {

	@Getter @Setter
	@JsonView(BasicView.class)
	private String title;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="author")
	@JsonView(BasicView.class)
	private Party author;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="publisher")
	@JsonView(BasicView.class)
	private Party publisher;
	
	
	public static interface BasicView extends BaseView { }
}
