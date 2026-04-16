package com.kh.member.controller;

import com.kh.member.model.service.MemberService;

public class MemberController {

	public int checkId(String memberId) {
		return new MemberService().checkId(memberId);
	}

}
