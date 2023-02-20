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

@WebServlet("/user.do")
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
//		String action = request.getParameter("getLogin");
//			System.out.println("action 값이 null 값이 나오겠지?:"+action); 
//		UserService withService = new UserService();
//		withService.service(action);
//		 request.setAttribute("id", result);
			
		PrintWriter writer = response.getWriter();
		String LoginCheck = (String)request.getParameter("id");
		System.out.println("id가져왔니?:"+LoginCheck);
		UserDAO userDAO = new UserDAO();
		boolean overlappedID = userDAO.login(LoginCheck);
		
		if(overlappedID == true) {
			writer.print("맞다");
		}else {
			writer.print("맞지 않다");
			
		}

		
		//서블릿에서 context path는 적지 않고, 자동으로 붙여준다(jsp로 바로 보여준다는건가?)
		RequestDispatcher dispatch = request.getRequestDispatcher("/LoginForm/LoginTest.jsp");
		dispatch.forward(request, response);
				
	}
}



////admin 회원리스트 목록을 출력할 예정
//try{
//if(action==null || action.equals("/")) {
//nextPage="/.jsp";
//}
//// 회원가입 페이지 출력
//if(action.equals("/")) {
//nextPage="/LoginForm/Sign-Up.jsp";
//// 로그인 페이지 출력
//}else if(action.equals("/")) {
//nextPage="/LoginForm/Log-In.jsp";
//// 마이페이지 회원정보(수정) 출력
//}else if(action.equals("/")) {
//nextPage="/MypageForm/My-Information.jsp";
//
//}else {
//
//}
//System.out.println("nextPage : "+ nextPage);
//}catch (Exception e) {
//e.printStackTrace();
//}
