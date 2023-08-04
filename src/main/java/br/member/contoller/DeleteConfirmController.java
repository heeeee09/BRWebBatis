package br.member.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.member.model.service.BRMemberService;

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
		
		int result = service.deleteMember(memberId, memberPw);
		if(result > 0) {
			session.invalidate();
			request.setAttribute("title", "회원 탈퇴 성공");
			request.setAttribute("msg", "회원 탈퇴를 성공하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceResult.jsp").forward(request, response);
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		} else {
			request.setAttribute("title", "회원 탈퇴 실패");
			request.setAttribute("msg", "회원 탈퇴에 실패했습니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}

	}
}
