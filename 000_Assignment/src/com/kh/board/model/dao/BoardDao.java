package com.kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.common.JdbcTemplate;
import com.kh.board.model.dto.BoardDto;

public class BoardDao {
	
	static {
		JdbcTemplate.registerDriver();
	}

	public int inserBoard(Connection conn, BoardDto boardDto) {
		int result = 0;
		String sql = """
				        INSERT
				          INTO
				               BOARD
				        VALUES
				               (
				               SEQ_BOARD.NEXTVAL,
				               ?,
				               ?
				               )       
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
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
		String sql = """
				        SELECT
				               BOARD_NO,
				               CATEGORY,
				               BOARD_NAME
				          FROM
				               BOARD
				         ORDER
				            BY
				               BOARD_NO DESC            
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
		String sql = """
				        UPDATE
				               BOARD
				           SET
				               CATEGORY = ?,
				               BOARD_NAME = ?
				         WHERE
				               BOARD_NO = ?          
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, bd.getCategory());
			pstmt.setString(2, bd.getBoardName());
			pstmt.setInt(3, bd.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
