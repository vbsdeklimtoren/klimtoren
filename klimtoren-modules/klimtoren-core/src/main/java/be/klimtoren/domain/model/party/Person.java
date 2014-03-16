package be.klimtoren.domain.model.party;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Table(name="persons")
@Entity
@PrimaryKeyJoinColumn(name="party_id")
public class Person extends Party {
	
}
