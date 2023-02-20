package UserPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import test.TestService;

@WebServlet("/user")
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
		
		//Controller>SERVICE>DAO>DB 자료를 SELECT하고 return 할 예정
		
		
		//회원가입 중복확인(controller>dao>DB>dao>
		PrintWriter writer = response.getWriter();
		String id = (String) request.getParameter("id");
		System.out.println("id = " + id);
		UserDAO userDAO = new UserDAO();
		boolean overlappedID = userDAO.overlappedID(id);
		
		//(결과 메시지 전송)
		if (overlappedID == true) {
			writer.print("not_usable");
		} else {
			writer.print("usable");
		}
		
		//로그인
		
	
		
		
		
		

		
		//서블릿에서 context path는 적지 않고, 자동으로 붙여준다(jsp로 바로 보여준다는건가?)
//		RequestDispatcher dispatch = request.getRequestDispatcher("/IdCheck.html");
//		dispatch.forward(request, response);
				
	}
}
