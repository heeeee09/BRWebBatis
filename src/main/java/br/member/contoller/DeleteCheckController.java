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
 * Servlet implementation class DeleteController
 */
@WebServlet("/member/delete.do")
public class DeleteCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/accountDelete.jsp").forward(request, response);

		
		/*
		 * 컨트롤러에서 입력받은 값을 팝업으로 다시 보내고 
		 * 팝업창에서 확인 누르면 true 리턴 -> 삭제 완료되도록
		 */
		
		
//		BaskinRobbins member = new BaskinRobbins(memberId, memberPw);
//		int result = service.deleteMember(member);
//		if(result > 0) {
//			request.setAttribute("title", "회원 탈퇴 성공");
//			request.setAttribute("msg", "회원 탈퇴를 성공하였습니다.");
//			request.getRequestDispatcher("/WEB-INF/views/common/serviceResult.jsp").forward(request, response);
//		} else {
//			request.setAttribute("title", "회원 탈퇴 실패");
//			request.setAttribute("msg", "회원 탈퇴에 실패했습니다.");
//			request.getRequestDispatcher("/WEB-INF/views/common/serviceResult.jsp").forward(request, response);
//			
//		}
		
		
		// DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?
		
		
		
//		BaskinRobbins memberDel = service.memberDelete(memberPw);
//		if(memberDel != null) {
//			if(memberDel.getMemberPw().equals(memberPwConfig)) {
//				
//			}else {
//				request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
//			}
//			response.sendRedirect("/member/account_delete_complite.jsp");
//		}else {
//			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
//		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String)request.getSession().getAttribute("memberId");
//		String memberPw = (String)request.getSession().getAttribute("memberPw");
		String pwCheck = request.getParameter("member-pw-check");
//		String memberPw = (String)request.getSession().getAttribute("memberPw");
		BRMemberService service = new BRMemberService();
		// 로그인 되어 있는 아이디와 확인을 위해 입력한 비밀번호의 값을 체크한다.
		// 있으면 true 리턴, 없으면 false 리턴
		Boolean check = service.userCheck(memberId, pwCheck);
		
		if(check == true) {
//			System.out.println(memberId + " " + memberPw);
//			request.setAttribute("memberId", memberId);
//			request.setAttribute("memberPw", pwCheck);
//			request.setAttribute("title", "회원 탈퇴");
			request.getRequestDispatcher("/WEB-INF/views/member/accountDeleteConfirm.jsp").forward(request, response);
//			request.getRequestDispatcher("/member/deleteConfirm.do").forward(request, response);

		} else {
			request.setAttribute("title", "회원 탈퇴 실패");
			request.setAttribute("msg", "비밀번호가 다릅니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}
		
	}

}
