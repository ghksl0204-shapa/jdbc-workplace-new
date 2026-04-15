package com.kh.board.model.service;

import static com.kh.board.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.BoardDto;
import com.kh.post.dto.PostDto;

public class BoardService {

	public int insertBoard(BoardDto boardDto) {
		Connection conn = getConnection();
		int result = new BoardDao().insertBoard(conn, boardDto); 
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

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = new BoardDao().deleteBoard(conn, boardNo);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

	public List<PostDto> pickBoard(int boardNo) {
		Connection conn = getConnection();
		List<PostDto> posts = new BoardDao().pickBoard(conn, boardNo);
		close(conn);
		return posts;
	}

}
