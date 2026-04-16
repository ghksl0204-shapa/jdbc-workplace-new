package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.board.common.JdbcTemplate;

public class MemberDao {
	
	private Properties prop = new Properties();

	static {
		JdbcTemplate.registerDriver();
	}
	
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int checkId(Connection conn, String memberId) {
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("checkId"))){
			pstmt.setString(1, memberId);
			try(ResultSet rset = pstmt.executeQuery()){
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
