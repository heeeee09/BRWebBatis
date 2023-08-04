package br.member.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.member.model.service.BRMemberService;
import br.member.model.vo.BRMember;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		String memberpw = request.getParameter("member-pw");
		
		
		BRMember member = new BRMember(memberId, memberpw);
		
		BRMemberService service = new BRMemberService();
		
		BRMember result = service.checkLogin(member);
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", result.getMemberId());
			session.setAttribute("memberPw", result.getMemberPw());
			session.setAttribute("memberName", result.getMemberName());
			session.setAttribute("memberBirth", result.getMemberBirth());
			session.setAttribute("memberGender", result.getMemberGender());
			response.sendRedirect("/index.jsp");
		}else {
			request.setAttribute("title", "로그인 실패");
			request.setAttribute("msg", "아이디 또는 비밀번호가 틀립니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}
	}

}
