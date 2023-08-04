package br.member.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.member.model.service.BRMemberService;
import br.member.model.vo.BRMember;

/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/member/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/userInformationModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = (String)request.getSession().getAttribute("memberId");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		BRMember memberEdit = new BRMember(memberId, memberPw, memberEmail, memberPhone, memberAddress);
		BRMemberService service = new BRMemberService();
		int result = service.oneMemberModify(memberEdit);
		if(result > 0) {
			// 성공하면 메인페이지
//			request.setAttribute("url", "/index.jsp");
			request.setAttribute("title", "회원 정보 수정 완료");
			request.setAttribute("msg", "회원 정보 수정을 완료했습니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
//			response.sendRedirect("/WEB-INF/views/common/serviceSuccess.jsp");
		} else {
			// 실패
			request.setAttribute("title", "회원 정보 수정 실패");
			request.setAttribute("msg", "회원 수정이 완료되지 않았습니다.");
//			request.getRequestDispatcher("/member/serviceFail.jsp").forward(request, response);
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}
		
		
	
	}

}
