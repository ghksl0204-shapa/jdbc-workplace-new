package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.service.BoardService;
import com.kh.post.dto.PostDto;

public class BoardController {

	public int insertBoard(BoardDto boardDto) {
		return new BoardService().insertBoard(boardDto);
	}

	public List<BoardDto> selectBoard() {
		return new BoardService().selectBoard();
	}

	public int updateBoard(BoardDto bd) {
		return new BoardService().updateBoard(bd);
	}

	public int deleteBoard(int boardNo) {
		return new BoardService().deleteBoard(boardNo);
	}

	public List<PostDto> pickBoard(int boardNo) {
		return new BoardService().pickBoard(boardNo);
	}

}
