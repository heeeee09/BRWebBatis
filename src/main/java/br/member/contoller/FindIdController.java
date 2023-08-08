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
 * Servlet implementation class FindIdController
 */
@WebServlet("/member/findId.do")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/findId.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("member-name");
		String memberphone = request.getParameter("member-phone");
		BRMemberService service = new BRMemberService();
		BRMember result = service.findId(memberName, memberphone);
		
		if(result != null) {
			request.setAttribute("title", "조회 성공");
			request.setAttribute("msg", "조회에 성공했습니다.\n 아이디:"+result.getMemberId());
			request.setAttribute("urlIndex", "/member/login.do");
			request.setAttribute("btnMsgIndex", "로그인 화면으로 이동");
			request.setAttribute("urlBack", "/member/findPw.do");
			request.setAttribute("btnMsgBack", "비밀번호 찾기");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceResult.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "조회 실패");
			request.setAttribute("msg", "데이터가 존재하지 않습니다/");
			request.setAttribute("urlIndex", "/member/findId.do");
			request.setAttribute("btnMsgIndex", "아이디 찾기로 이동");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceResultOneBtn.jsp").forward(request, response);
		}
		
	}
}

