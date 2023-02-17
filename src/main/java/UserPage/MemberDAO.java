package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	public List listMembers() {
		List membersList = new ArrayList();
		
		try {
			
			// DB 접속
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// sql 만들기
			String sql = " select * from t_member ";
			sql 	  += " order by joindate desc";
			
			// 실행 준비
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 실행
			ResultSet rs = ps.executeQuery();
			
			// 결과 처리
			while( rs.next() ) {
			// rs.next() : 커서 이동
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				
				// VO에 담기
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joindate);
				
				// List에 담기
				membersList.add(vo);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return membersList;
	}
}
