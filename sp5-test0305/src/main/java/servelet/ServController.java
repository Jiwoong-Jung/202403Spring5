package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import com.board.AppContext;
import com.board.BoardService;
import com.board.Greeter;

/**
 * Servlet implementation class ServController
 */
//@WebServlet("/")
public class ServController extends HttpServlet {
	
	@Autowired
	Greeter greeter;
	
	@Autowired
	BoardService boardService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	AnnotationConfigApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(AppContext.class);
		
    	greeter.greet("안녕");
		String view = null;
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        if (com.equals("/") || com.equals("/list")) {
        	String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("msgList",
            		boardService.getMsgList(pageNo));
            request.setAttribute("pgnList",
            		boardService.getPagination(pageNo));
            view = "list.jsp";
        }
        
     // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
