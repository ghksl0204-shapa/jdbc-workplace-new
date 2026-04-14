package com.kh.board.model.dto;

public class BoardDto {

	private int boardNo;
	private String category;
	private String boardName;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(String category, String boardName) {
		super();
		this.category = category;
		this.boardName = boardName;
	}

	public BoardDto(int boardNo, String category, String boardName) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardName = boardName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", category=" + category + ", boardName=" + boardName + "]";
	}
	
}
