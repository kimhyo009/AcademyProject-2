package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testmvc")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public TestController() {
        super();
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
		
//		String action = request.getPathInfo();
//		System.out.println("action:"+action); //출력 한번 해보고
		System.out.println("dohandle 호출");
		
		//패턴 1번 유형(controller-> service -> dao)
		TestService service = new TestService();
			service.service();
//------------------------------------------------------------------------		
		//전달연습!!!!!!!!!!!!!!!!!!!!!
		String a = request.getParameter("controller");
		TestService service2 = new TestService();
		service2.service2(a);
		 // 1. "controller"에 담긴 키 값이 String a 값에 담기고 
		 int result = service2.service3(a);
		 //2. String a 값이 service3(a) 값에 넘어 오고 이것은 
		 //12. 리턴되어 온 result 값을 
		 System.out.println("service에서 받은 int 값이 return되어 옴"+ result);
		 
//----------------------------------------------------------------------- 	
		//jsp(view)로 전달해 봅시다
		 //response.getWriter().println("<h1>"+result+"</h1>")
		 // html로 바로 출력도 가능하지만, mcv로 나누어 표현할 때
		 
		 //SendRedirect 와 RequestDispatcher를 이용할 수 있다
		 //방법 1. RequestDispatcher
		 
		 request.setAttribute("k2", result);
		 //13. 위의 int result 값을 가져와서 jsp에 출력함.
		 
		RequestDispatcher rd = request.getRequestDispatcher("/LoginForm/mainTest.jsp");
		rd.forward(request, response);
		 
	}
}
