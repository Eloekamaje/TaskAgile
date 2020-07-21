package com.taskagile.domain.model.user.event;

import org.springframework.util.Assert;

import com.taskagile.domain.common.events.DomainEvent;
import com.taskagile.domain.model.user.User;

public class UserRegisteredEvent extends DomainEvent{
	
	private User user;
	
	public UserRegisteredEvent(User user) {
		super(user);
		Assert.notNull(user, "Parameter `user` must not be null");
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    UserRegisteredEvent that = (UserRegisteredEvent) o;
	    return that.user.equals(this.user);
	}

	public int hashCode() {
	    return this.user.hashCode();
	}

	public String toString() {
	    return "UserRegisteredEvent{" +
	      "user='" + user + '\'' +
	      "timestamp='" + getTimestamp() + '\'' +
	      '}';
	}
}
