package be.klimtoren.domain.shared;

public interface DomainEvent<T> {
	boolean sameEventsAs(T other);
}
