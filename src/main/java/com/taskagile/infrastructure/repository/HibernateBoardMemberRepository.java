package com.taskagile.infrastructure.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.taskagile.domain.model.board.BoardMember;
import com.taskagile.domain.model.board.BoardMemberRepository;

@Repository
public class HibernateBoardMemberRepository extends HibernateSupport implements BoardMemberRepository {

	HibernateBoardMemberRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void save(BoardMember boardMember) {
		entityManager.persist(boardMember);
	    entityManager.flush();

	}

}
