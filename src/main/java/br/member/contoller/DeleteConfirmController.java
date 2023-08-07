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
 * Servlet implementation class DeletePopController
 */
@WebServlet("/member/deleteConfirm.do")
public class DeleteConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/accountDeleteConfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String)request.getSession().getAttribute("memberId");
		String memberPw = (String)request.getSession().getAttribute("memberPw");
		BRMemberService service = new BRMemberService();
		BRMember mOne = new BRMember(memberId, memberPw);
		
		int result = service.deleteMember(memberId, mOne);
		if(result > 0) {
			session.invalidate();
			request.setAttribute("title", "회원 탈퇴 성공");
			request.setAttribute("url", "/index.jsp");
			request.setAttribute("btnMsg", "메인으로 이동");
			request.getRequestDispatcher("/common/serviceResultOneBtn.do").forward(request, response);
		} else {
			request.setAttribute("title", "회원 탈퇴 실패");
			request.setAttribute("url", "/member/myPage.do");
			request.setAttribute("btnMsg", "마이페이지로 이동");
			request.getRequestDispatcher("/common/serviceResultOneBtn.do").forward(request, response);
		}

	}
}
