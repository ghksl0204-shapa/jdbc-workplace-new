package com.kh.board.model.service;

import static com.kh.board.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.BoardDto;

public class BoardService {

	public int inserBoard(BoardDto boardDto) {
		Connection conn = getConnection();
		int result = new BoardDao().inserBoard(conn, boardDto); 
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

	public List<BoardDto> selectBoard() {
		Connection conn = getConnection();
		List<BoardDto> boards = new BoardDao().selectBoard(conn);
		close(conn);
		return boards;
	}

	public int updateBoard(BoardDto bd) {
		Connection conn = getConnection();
		int result = new BoardDao().updateBoard(conn, bd);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

}
