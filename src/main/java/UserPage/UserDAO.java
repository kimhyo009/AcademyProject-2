package UserPage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
		private Connection con;
		private PreparedStatement pstmt;
		private DataSource dataFactory;

		//DB접속
		public UserDAO() {
			try {
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("DB접속 실패");
			}
		}
		
		//회원가입 중복확인
		public boolean overlappedID(String id){
			boolean result = false;
			try {
				con = dataFactory.getConnection();
				String query = "select decode(count(*),1,'true','false') as result from t_member";
				query += " where id=?";
				System.out.println("prepareStatememt: " + query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				result = Boolean.parseBoolean(rs.getString("result"));
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		//회원가입
		public List listUser() {
			List list = new ArrayList();
			try {
				con = dataFactory.getConnection();
				String query = "select * from t_member order by joinDate desc ";
				System.out.println("prepareStatememt: " + query);
				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String email = rs.getString("email");
					Date joinDate = rs.getDate("joinDate");
					UserVO vo = new UserVO();
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setName(name);
					vo.setEmail(email);
					vo.setJoinDate(joinDate);
					list.add(vo);
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public void addUser(UserVO userVO) {
			try {
				Connection con = dataFactory.getConnection();
				String id = userVO.getId();
				String pwd = userVO.getPwd();
				String name = userVO.getName();
				String email = userVO.getEmail();
				String query = "insert into t_member";
				query += " (id,pwd,name,email)";
				query += " values(?,?,?,?)";
				System.out.println("prepareStatememt: " + query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//로그인
		public boolean login(UserVO userVO) {
			boolean result = false;
			try {
               Connection con = dataFactory.getConnection();
               String query = "SELECT * FROM USER WHERE id=? AND pwd=?";
               pstmt = con.prepareStatement(query);
               pstmt.setString(1, id);
               pstmt.setString(2, pwd);
               
               ResultSet rs = pstmt.executeQuery();
               	if(rs.next()){
               		result = true;
               	}
               pstmt.close();
               con.close();
               rs.close();
               
            } catch (SQLException e) {
               e.printStackTrace();
            }
			
            return result;
		
	}
}