package com.kh.member.dto;

public class MamberDto {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String email;
	
	public MamberDto() {
	}
	
	public MamberDto(String memberId, String memberPwd, String email) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.email = email;
	}

	public MamberDto(int memberNo, String memberId, String memberPwd, String email) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.email = email;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
