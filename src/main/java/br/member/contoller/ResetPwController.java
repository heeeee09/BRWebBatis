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
 * Servlet implementation class ResetPwController
 */
@WebServlet("/member/resetPw.do")
public class ResetPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPwController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*	HttpSession session = request.getSession();
 *	String memberId = (String) request.getSession().getAttribute("memberId");
 * -> 아이디를 session에 저장했더니 헤더에 로그인 정보가 저장되었다 판단되어서 마이페이지 창이 뜬다..
 * 그냥 로그인 정보를 입력 받는 걸로 수정했다.
 */
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		BRMemberService service = new BRMemberService();
		BRMember member = new BRMember(memberId, memberPw);
		int result = service.resetPw(member);
		
		if(result > 0) {
//			session.invalidate();	
			request.setAttribute("title", "재설정 완료");
			request.setAttribute("msg", "비밀번호 재설정이 완료되었습니다. 새로운 비밀번호로 로그인 해주세요.");
			request.setAttribute("url", "/member/login.do");
			request.setAttribute("btnMsg", "로그인");
			request.getRequestDispatcher("/WEB-INF/common/serviceResultBtn.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "재설정 실패");
			request.setAttribute("msg", "비밀번호 재설정이 완료되지 않았습니다. 다시 시도해주세요.");
			request.setAttribute("url", "/member/resetPw.do");
			request.setAttribute("btnMsg", "이전 페이지로 이동");
			request.getRequestDispatcher("/WEB-INF/common/serviceResultBtn.jsp").forward(request, response);
		}
	}

}
