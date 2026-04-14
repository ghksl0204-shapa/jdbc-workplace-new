package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdTooLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean checkId(String memberId) {
		Connection conn = getConnection();
		boolean result = new MemberDao().checkId(conn, memberId);
		close(conn);
		return result;
	}

	public int signUp(MemberDto memberDto) {
		if(memberDto.getMemberId().length() > 30) {
			throw new MemberIdTooLargeException("아이디가 너무 길어요");
		}
		// 모든검사를 다 넘어갔다고 가정
		Connection conn = getConnection();
		MemberDao md = new MemberDao();
		if(md.checkId(conn, memberDto.getMemberId())) {
			throw new DuplicateMemberIdException("중복아이디입니다.");
		}
		int result = md.signUp(conn, memberDto);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
}
