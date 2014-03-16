package be.klimtoren.domain.shared;

import java.io.Serializable;

public interface ValueObject<T, ID extends Serializable> extends Serializable {
	boolean sameValueAs(T other);
}
