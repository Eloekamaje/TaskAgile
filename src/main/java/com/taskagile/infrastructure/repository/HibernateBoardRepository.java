package com.taskagile.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.taskagile.domain.model.board.Board;
import com.taskagile.domain.model.board.BoardRepository;
import com.taskagile.domain.model.user.UserId;

@Repository
public class HibernateBoardRepository extends HibernateSupport implements BoardRepository{

	HibernateBoardRepository(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Board> findBoardsByMembership(UserId userId) {
		String sql =
			  "   SELECT b.* FROM board b LEFT JOIN board_member bm " +
			  "   WHERE bm.board_id = b.id AND bm.user_id = :userId ";
		NativeQuery<Board> query = getSession().createNativeQuery(sql, Board.class);
		query.setParameter("userId", userId.value());
		return query.list();
	}

	@Override
	public void save(Board board) {
		entityManager.persist(board);
		entityManager.flush();
	}

}
