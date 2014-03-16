package be.klimtoren.domain.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@SuppressWarnings("rawtypes")
@MappedSuperclass
public abstract class ValueObjectSupport<T extends ValueObject, ID  extends Serializable> implements ValueObject<T, ID> {
	private static final long serialVersionUID = 4264643665912405261L;

	private transient int cachedHashCode = 0;

	//needed for hibernate
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue
	@Getter @Setter
	private ID id;
	
	
	
	@Override
	public boolean sameValueAs(T other) {
		return other != null && EqualsBuilder.reflectionEquals(this, other, false);
	}

	@Override
	public final int hashCode() {
		int h = cachedHashCode;
		if(h == 0) {
			h = HashCodeBuilder.reflectionHashCode(this, false);
			cachedHashCode = h;
		}
		
		return h;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final boolean equals(final Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		return sameValueAs((T) o);
	}
}
