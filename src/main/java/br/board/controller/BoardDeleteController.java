package br.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.board.model.service.BRBoardService;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/board/delete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BRBoardService service = new BRBoardService();
		int result = service.deleteBoard(boardNo);
		if(result > 0) {
			request.setAttribute("title", "삭제 성공");
			request.setAttribute("msg", "문의사항 삭제에 성공했습니다.");
			request.setAttribute("urlIndex", "/index.jsp");
			request.setAttribute("btnMsgIndex", "메인으로 이동");
			request.setAttribute("urlBack", "/board/boardList.do?currentPage=1");
			request.setAttribute("btnMsgBack", "문의사항으로 이동");
			request.getRequestDispatcher("/common/serviceResult.do").forward(request, response);
		}else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "문의사항 삭제에 실패했습니다.");
			request.setAttribute("url", "/board/list.do?currentPage=1");
			request.setAttribute("btnMsg", "이전 화면으로 이동");
			request.getRequestDispatcher("/common/serviceResultOneBtn.do").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
