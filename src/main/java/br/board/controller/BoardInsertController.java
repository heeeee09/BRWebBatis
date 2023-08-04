package br.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.board.model.service.BRBoardService;
import br.board.model.vo.BRBoard;
import br.member.model.service.BRMemberService;
import br.member.model.vo.BRMember;

/**
 * Servlet implementation class noticeInsertController
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/boardInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String boardWriter = (String)request.getSession().getAttribute("memberId");
		BRBoardService service = new BRBoardService();
		BRBoard board = new BRBoard(boardSubject, boardContent, boardWriter);
		int result = service.boardInsert(board);
		if(result > 0) {
			request.setAttribute("title", "게시글 작성 완료");
			request.setAttribute("msg", "게시글이 작성되었습니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}else {
			request.setAttribute("title", "게시글 작성 실패");
			request.setAttribute("msg", "게시글이 작성이 완료되지 않았습니다.");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}
	}

}
