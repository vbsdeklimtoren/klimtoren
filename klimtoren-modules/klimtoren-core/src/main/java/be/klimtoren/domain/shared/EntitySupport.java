package be.klimtoren.domain.shared;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.map.annotate.JsonView;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
@MappedSuperclass
public class EntitySupport<T extends Entity, ID extends Serializable> implements Entity<T, ID> {
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue
	@Getter @Setter
	@JsonView(BaseView.class)
	protected ID id;
	
	
	@Override
	public boolean sameIdentityAs(T other) {
		return other != null && this.getId().equals(other.getId());
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		return sameIdentityAs((T) o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		T clone = null;

		try
		{
			clone = (T) this.getClass().newInstance();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		// Walk up the superclass hierarchy
		for (Class<?> obj = this .getClass();
				!obj.equals(Object.class);
				obj = obj.getSuperclass())
		{
			Field[] fields = obj.getDeclaredFields();
			for (int i = 0; i < fields.length; i++)
			{
				fields[i].setAccessible(true);
				try
				{
					fields[i].set(clone, fields[i].get(this));
				}
				catch (IllegalArgumentException e){}
				catch (IllegalAccessException e){}
			}
		}
		return clone;
	}

}
