package com.kh.post.dto;

import java.sql.Date;

public class PostDto {

	private int postNo;
	private String postName;
	private String postContent;
	private Date postDate;
	private int boardNo;
	private int memberNo;
	
	public PostDto() {
	}

	public PostDto(String postName, String postContent) {
		super();
		this.postName = postName;
		this.postContent = postContent;
	}

	public PostDto(int postNo, String postName, String postContent, Date postDate, int boardNo, int memberNo) {
		super();
		this.postNo = postNo;
		this.postName = postName;
		this.postContent = postContent;
		this.postDate = postDate;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
