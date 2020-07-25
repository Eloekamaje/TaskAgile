package com.taskagile.domain.model.board;

public interface BoardMemberRepository {
	
	
	/**
	 * Save a board
	 *
	 * @param board the board to save
	*/
	void save(BoardMember boardMember);

}
