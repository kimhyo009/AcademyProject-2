package UserPage;

import java.io.IOException;
import java.util.List;

<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
>>>>>>> 3d6966bc0028e0d9943b421064c81327b6c8b836
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
@WebServlet("/mypage.do")
=======
@WebServlet("/mypage")
>>>>>>> 3d6966bc0028e0d9943b421064c81327b6c8b836
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MyPageController() {
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
<<<<<<< HEAD
		String action = request.getPathInfo();
			System.out.println("action:"+action); //출력 한번 해보고
		String nextPage = null;
		
		try {
				//로그인된 마이페이지(회원정보) 출력
			if(action.equals("/")) {
				nextPage="/MypageForm/My-Information.jsp";
				// 마이페이지 예매정보 출력
			}else if(action.equals("/")) {
				nextPage="/MypageForm/My-historyA.jsp";
				//  마이페이지 구매내역 출력
			}else if(action.equals("/")) {
				nextPage="/MypageForm/My-historyB.jsp";
				// 마이페이지 문의내역 출력
			}else if(action.equals("")) {
				nextPage="/MypageForm/My-historyC.jsp";
			}else {
			}
			System.out.println("nextPage : "+ nextPage);
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
=======
	
>>>>>>> 3d6966bc0028e0d9943b421064c81327b6c8b836
	}
}
