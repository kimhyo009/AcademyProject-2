package UserPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	
    public void init() throws ServletException {
    	userDAO = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
			System.out.println("action:"+action); //출력 한번 해보고
		String nextPage = null;
		try {
			
				//admin 회원리스트 목록을 출력할 예정
			if(action==null || action.equals("/")) {
				nextPage="/.jsp";
			}
				// 회원가입 페이지 출력
			if(action.equals("/")) {
				nextPage="/LoginForm/Sign-Up.jsp";
				// 로그인 페이지 출력
			}else if(action.equals("/")) {
				nextPage="/LoginForm/Log-In.jsp";
				// 마이페이지 회원정보(수정) 출력
			}else if(action.equals("/")) {
				nextPage="/MypageForm/My-Information.jsp";
				
			}else {
				
			}
			System.out.println("nextPage : "+ nextPage);
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
