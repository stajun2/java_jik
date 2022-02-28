package kr.green.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1 {
	
	@Test
	public void test() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/community?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul","root","cjgreen");
			System.out.println("DB 연결 성공");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from member");
			while(rs.next()) {
				System.out.println("id   : " + rs.getString("me_id"));
				System.out.println("name : " + rs.getString("me_name"));
			}
		}catch(Exception e) {
			System.out.println("DB 연결 실패");
		}
	}
}
