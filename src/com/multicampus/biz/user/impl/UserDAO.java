package com.multicampus.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;
import com.multicampus.biz.user.UserVO;

@Repository
//DAO(Data Access Object)
public class UserDAO {
	// DB 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// 회원 상세 조회
	/* (non-Javadoc)
	 * @see com.multicampus.biz.user.impl.UserService#getUser(com.multicampus.biz.user.UserVO)
	 */
	public UserVO getUser(UserVO vo){
		System.out.println("---> JDBC로 getUser() 기능 구현");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
