package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.common.JdbcTemplate;
import com.kh.board.model.dto.BoardDto;
import com.kh.post.dto.PostDto;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	static {
		JdbcTemplate.registerDriver();
	}

	public BoardDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/board-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(Connection conn, BoardDto boardDto) {
		int result = 0;

		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertBoard"))){
			pstmt.setString(1, boardDto.getCategory());
			pstmt.setString(2, boardDto.getBoardName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<BoardDto> selectBoard(Connection conn) {
		List<BoardDto> boards = new ArrayList();
		ResultSet rset = null;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoard"))) {
			rset = pstmt.executeQuery();
			while(rset.next()) {
				boards.add(new BoardDto(rset.getInt("BOARD_NO"), rset.getString("CATEGORY"), rset.getString("BOARD_NAME"))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}

	public int updateBoard(Connection conn, BoardDto bd) {
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateBoard"))){
			pstmt.setString(1, bd.getCategory());
			pstmt.setString(2, bd.getBoardName());
			pstmt.setInt(3, bd.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deletBoard"))){
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<PostDto> pickBoard(Connection conn, int boardNo) {
		List<PostDto> posts = new ArrayList();
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("pickBoard"))){
			pstmt.setInt(1, boardNo);
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					posts.add(new PostDto(rset.getInt("POST_NO"), rset.getString("POST_NAME"), rset.getString("POST_CONTENT"), rset.getDate("POST_DATE"), boardNo, rset.getInt("MEMBER_NO")));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}
}
