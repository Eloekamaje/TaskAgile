package com.taskagile.domain.model.team.events;

import com.taskagile.domain.common.events.DomainEvent;
import com.taskagile.domain.model.team.Team;

public class TeamCreatedEvent extends DomainEvent {

  private static final long serialVersionUID = 2714833255396717504L;

  private Team team;

  public TeamCreatedEvent(Object source, Team team) {
    super(source);
    this.team = team;
  }

  public Team getTeam() {
    return team;
  }

@Override
public int hashCode() {
	return this.team.hashCode();
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TeamCreatedEvent other = (TeamCreatedEvent) obj;
	if (team == null) {
		if (other.team != null)
			return false;
	} else if (!team.equals(other.team))
		return false;
	return true;
}
}
