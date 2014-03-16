package be.klimtoren.domain.shared;

import java.io.Serializable;

public interface Entity<T, ID extends Serializable> {
	boolean sameIdentityAs(T other);
	
	ID getId();
	T clone();
}
