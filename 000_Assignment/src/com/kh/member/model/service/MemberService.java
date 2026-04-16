package com.kh.member.model.service;

import static com.kh.board.common.JdbcTemplate.getConnection;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;

public class MemberService {

	public int checkId(String memberId) {
		Connection conn = getConnection();
		int result = new MemberDao().checkId(conn, memberId);
		return 0;
	}

}
