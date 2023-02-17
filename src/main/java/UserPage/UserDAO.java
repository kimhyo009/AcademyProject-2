package UserPage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

	public class UserDAO {
		
		public List listMembers() {
			List membersList = new ArrayList();
			
		try {
			//		DB 접속
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); // JNDI 사용을 위한 설정
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			//		SQL 준비
			String sql = "insert into join_member (id, pwd, name, phoneNumber, email) ";
			sql       += " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, phoneNumber);
			ps.setString(5, email);
			
			//		SQL 실행
			int result = ps.executeUpdate();
			//		실행 결과를 활용
			System.out.println("insert된 recode의 수 : "+ result);
			
			ps.close();
			con.close();
			
			con = dataFactory.getConnection();
			sql = "select * from join_member";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			while( rs.next()) {
				String getId = rs.getString("id");
				String getPwd1 = rs.getString("pwd");
				String getName = rs.getString("name");
				Integer getPhoneNumber = rs.getInt("phoneNumber");
				String getEmail = rs.getString("email");
				
			}
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
}
