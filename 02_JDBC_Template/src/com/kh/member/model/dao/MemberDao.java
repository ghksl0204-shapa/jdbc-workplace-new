package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.member.model.dto.MemberDto;

public class MemberDao {

	public boolean checkId(Connection conn, String memberId) {
		String sql = """
				        SELECT
				               COUNT(*)
				          FROM
				               JDBC_MEMBER
				         WHERE
				               MEMBER_ID = ?      
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			return rset.getInt("COUNT(*)") > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int signUp(Connection conn, MemberDto memberDto) {
		int result = 0;
		String sql = """
                        INSERT
                          INTO
                               JDBC_MEMBER
                        VALUES
                               (
                               ?
                             , ?
                             , ?
                               )       				
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, memberDto.getMemberId());
			pstmt.setString(2, memberDto.getMemberPwd());
			pstmt.setString(3, memberDto.getMemberName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
