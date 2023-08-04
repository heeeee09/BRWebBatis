package br.member.contoller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.member.model.service.BRMemberService;
import br.member.model.vo.BRMember;

/**
 * Servlet implementation class Join
 */
@WebServlet("/member/registor.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberBirth = request.getParameter("member-birthday");
		String memberGender = request.getParameter("member-gender");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		
		BRMember member = new BRMember(memberId, memberPw, memberName, memberBirth, memberGender, memberEmail, memberPhone, memberAddress);
		
		BRMemberService service = new BRMemberService();
		
		int result = service.insertMember(member);
		if(result > 0) {
			request.setAttribute("title", "회원가입 성공");
			request.setAttribute("msg", "회원가입이 완료되었습니다.");
			response.sendRedirect("/common/serviceResult.do");
		} else {
			// 실패
			request.setAttribute("title", "회원가입 실패");
			request.setAttribute("msg", "회원가입 실패했어요");
			request.getRequestDispatcher("/member/serviceResult.do").forward(request, response);
		}
	}

}
