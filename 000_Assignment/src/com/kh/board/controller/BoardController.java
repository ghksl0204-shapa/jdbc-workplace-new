package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.service.BoardService;

public class BoardController {

	public int insertBoard(BoardDto boardDto) {
		return new BoardService().inserBoard(boardDto);
	}

	public List<BoardDto> selectBoard() {
		return new BoardService().selectBoard();
	}

	public int updateBoard(BoardDto bd) {
		return new BoardService().updateBoard(bd);
	}

}
