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
		private  DataSource dataFactory;
		private  Connection conn;
		private  PreparedStatement pstmt;
		
		public void DbDAO(){
		try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
            System.out.println("");

         } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
				public boolean login(String ename) {
				boolean result = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = dataFactory.getConnection();
					String query = "SELECT * FROM emp WHERE ename=?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, ename);
//					pstmt.setString(2, emptno);
					
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

