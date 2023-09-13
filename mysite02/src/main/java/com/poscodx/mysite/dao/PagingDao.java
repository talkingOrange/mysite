package com.poscodx.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poscodx.mysite.vo.PagingVo;

public class PagingDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.178:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
	
	public PagingVo findTotalCount() {
		PagingVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new PagingVo();

				vo.setTotalCount(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vo;
	}
}
