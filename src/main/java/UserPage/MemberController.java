package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO memberDAO;
	
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = memberDAO.listMembers();
		
		request.setAttribute("list", list);
		
		// 서블릿에서 context path는 적지않는다-자동으로 붙여준다
		RequestDispatcher rd = request.getRequestDispatcher("/test01/listMembers.jsp");
		rd.forward(request, response);
	}

}
