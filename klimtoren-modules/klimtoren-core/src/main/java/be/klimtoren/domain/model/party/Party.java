package be.klimtoren.domain.model.party;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.map.annotate.JsonView;

import be.klimtoren.domain.model.kind.Kind;
import be.klimtoren.domain.model.resource.Book;
import be.klimtoren.domain.shared.BaseView;
import be.klimtoren.domain.shared.EntitySupport;

@Table(name="parties")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=true)
public class Party extends EntitySupport<Party, Long> {
	 
	@JsonView(FullView.class)
	private String descriptiveInformation;
	
	@JsonView(FullView.class)
	private String name;
	
	@JsonView({BasicView.class, Book.BasicView.class})
	private String displayName;
	
	@ManyToOne
	@JsonView(FullView.class)
	private Kind kind;
	
	@ManyToOne
	@JsonView(FullView.class)
	private Kind primaryKind;

	@OneToMany(mappedBy="forParty")
	@JsonView(ProfileView.class)
	private List<FullName> names;
	
	
	
	/*------------------------------
	 | Methods
	 -----------------------------*/
	public void addFullName(FullName fullName) {
		if(names == null) {
			names = new ArrayList<FullName>();
		}
		names.add(fullName);
	}
	/*------------------------------
	 | Properties
	 -----------------------------*/
	public FullName fullName() {
		if(names != null && names.size() > 0)
			return names.get(0);
		else
			return null;
	}
	
	/*------------------------------
	 | Views
	 -----------------------------*/
	public static interface BasicView extends BaseView { }
	public static interface ProfileView extends BasicView { }
	public static interface FullView extends ProfileView { }
}
