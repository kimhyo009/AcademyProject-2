package UserPage;

<<<<<<< HEAD
=======
import java.io.PrintWriter;
>>>>>>> 3d6966bc0028e0d9943b421064c81327b6c8b836
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
<<<<<<< HEAD
import javax.sql.DataSource;

	public class UserDAO {
		private DataSource dataFactory;
		private Connection conn;
		private PreparedStatement pstmt;
			
			//배열을 만들어서 회원 정보를 담고 
//그러니까 회원정보를 담은건가? 너무 어려워...
			public List UserList() {
				List userList = new ArrayList();
				
					//DB접속하고
				try {				
					Context ctx = new InitialContext();
					Context envContext = (Context) ctx.lookup("java:/comp/env");
					dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
					conn = dataFactory.getConnection();
					
					// sql 만들고, 실행준비, 실행하고
					conn = dataFactory.getConnection();
					String query = "SELECT * FROM  USER order by joinDate desc";
					System.out.println(query);
					pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
					
					//결과를 처리
					while (rs.next()) {
						String id = rs.getString("id");
						String pwd = rs.getString("pwd");
						String name = rs.getString("name");
						String email = rs.getString("email");
						Date joinDate = rs.getDate("joinDate");
						
					/// VO에 담기
						UserVO vo = new UserVO();
						vo.setId(id);
						vo.setPwd(pwd);
						vo.setName(name);
						vo.setEmail(email);
						vo.setJoinDate(joinDate);
						
						// List에 담기
						userList.add(vo);
					}
			
					rs.close();
					pstmt.close();
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return userList;
			}
	
			//회원가입
			public void addUser(UserVO user) {
				try {
					conn = dataFactory.getConnection();
					String id = user.getId();
					String pwd = user.getPwd();
					String name = user.getName();
					String email = user.getEmail();
					String query = "INSERT INTO USER(id, pwd, name, email)" + " VALUES(?, ? ,? ,?)";
						System.out.println(query);
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);
					pstmt.setString(4, email);
					pstmt.executeUpdate();
					
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//로그인
			public boolean login(String id, String pwd) {
				boolean result = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = dataFactory.getConnection();
					String query = "SELECT * FROM USER WHERE id=? AND pwd=?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					
					rs = pstmt.executeQuery();
					//id, pwd가 일치하는 것이 나올때  rs에에 값이 들어오고 맞나?
					
						if (rs.next()) {
							result = true;
						}
					pstmt.close();
					conn.close();
					rs.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result;
			}
	}
=======
import javax.naming.NamingException;
import javax.sql.DataSource;

	public class UserDAO {
		
		public List UserList() {
			List userList = new ArrayList();
					try {
							Context ctx = new InitialContext();
							Context envContext = (Context) ctx.lookup("java:/comp/env"); // JNDI 사용을 위한 설정
							DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
							Connection con = dataFactory.getConnection();
												
							String sql = " select * from t_member ";							//생성하고
							sql 	  += " order by joindate desc";
							PreparedStatement ps = con.prepareStatement(sql); //준비하고
							ResultSet rs = ps.executeQuery();										//실행하고
						
								while( rs.next() ) {																	//결과처리
									String id = rs.getString("id");
									String pwd = rs.getString("pwd");
									String name = rs.getString("name");
									String number = rs.getString("number");
									String email = rs.getString("email");
									Date joindate = rs.getDate("joindate");
									
									UserVO vo = new UserVO();											//vo을 담고
									vo.setId(id);
									vo.setPwd(pwd);
									vo.setName(name);
									vo.setNumber(number);
									vo.setEmail(email);
									vo.setJoinDate(joindate);
									
									userList.add(vo);														//vo를 List에 담고
								}		
							rs.close();
							ps.close();
							con.close();
								
					} catch(Exception e) {
							e.printStackTrace();
					}
				return userList; 
				}
		}
>>>>>>> 3d6966bc0028e0d9943b421064c81327b6c8b836
