package UserPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 한글깨짐방지
		request.setCharacterEncoding("utf-8");  
		//응답 한글 깨짐 방지
	    response.setContentType("text/html; charset=utf-8;"); 
	    
		// 전달 받아서 변수에 저장
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		// 출력
		System.out.println("아이디 : "+ id);
		System.out.println("비밀번호 : "+ pwd1);
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("이메일 : "+ email);
		
		
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
			ps.setString(2, pwd1);
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
				
				out.println("<br>아이디 : "+ getId);
				out.println("<br>비밀번호 : "+ getPwd1);
				out.println("<br>이름 : "+ getName);
				out.println("<br>전화번호 : "+ getPhoneNumber);
				out.println("<br>이메일 : "+ getEmail);
				out.println("<hr>");
			}
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
			
			// DB에서 가져와서 변수에 저장
			// 출력
			// 브라우저로 응답
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
