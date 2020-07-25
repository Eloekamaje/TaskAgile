package com.taskagile.domain.application.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskagile.domain.application.TeamService;
import com.taskagile.domain.application.commands.CreateTeamCommand;
import com.taskagile.domain.common.events.DomainEventPublisher;
import com.taskagile.domain.model.team.Team;
import com.taskagile.domain.model.team.TeamRepository;
import com.taskagile.domain.model.team.events.TeamCreatedEvent;
import com.taskagile.domain.model.user.UserId;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	private TeamRepository teamRepository;
	private DomainEventPublisher domainEventPublisher;
	
	public TeamServiceImpl(TeamRepository teamRepository, 
			DomainEventPublisher domainEventPublisher) {
		this.domainEventPublisher = domainEventPublisher;
		this.teamRepository = teamRepository;
	}

	@Override
	public List<Team> findTeamsByUserId(UserId userId) {
		return teamRepository.findTeamsByUserId(userId);
	}

	@Override
	public Team createTeam(CreateTeamCommand command) {
		Team team = Team.create(command.getName(), command.getUserId());
	    teamRepository.save(team);
	    domainEventPublisher.publish(new TeamCreatedEvent(this, team));
	    return team;
	}

}
