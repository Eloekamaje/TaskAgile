package com.taskagile.domain.common.events;

public interface DomainEventPublisher {
	/**
	 * Publish a domain event
	 * @param event instance of <code>DomainEvent</>
	 */
	void publish(DomainEvent event);

}
