package com.example.JakSim;

import com.example.JakSim.login.JDBCTest;
import groovy.util.logging.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.sql.*;

@SpringBootTest
@Log4j
class TstApplicationTests {
	@Autowired
	private DataSource ds;

	@Test
	void contextLoads() {
	}

	@Test
	public void testConnection() throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user_info where user_id = ?");
		pstmt.setString(1, "hye8997");
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getString("USER_ID"));
			System.out.println(rs.getString("USER_NAME"));
		}

		if(!conn.isClosed())
			conn.close();

	}

	@Test
	@DisplayName("JDBC 성공했나?")
	public void testJDBCConnection() throws SQLException{
		JDBCTest jdbcTest = new JDBCTest();
		jdbcTest.findById();
	}

}
