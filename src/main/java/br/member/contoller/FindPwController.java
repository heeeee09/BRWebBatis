package br.member.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.member.model.service.BRMemberService;
import br.member.model.vo.BRMember;

/**
 * Servlet implementation class FindIdController
 */
@WebServlet("/member/findPw.do")
public class FindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/findPw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		BRMember member = new BRMember(memberId, memberEmail, memberPhone);
		BRMemberService service = new BRMemberService();
		BRMember result = service.findPw(member);
		System.out.println(result);
		
		if(result.getMemberId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", result.getMemberId());
			request.getRequestDispatcher("/WEB-INF/views/member/resetPw.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "조회 실패");
			request.setAttribute("msg", "데이터가 존재하지 않습니다.");
			request.setAttribute("urlIndex", "/member/findPw.do");
			request.setAttribute("btnMsgIndex", "이전 화면으로 이동");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceResultOneBtn.jsp").forward(request, response);
		}
		
	}
}

