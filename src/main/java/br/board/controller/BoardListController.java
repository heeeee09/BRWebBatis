package br.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.board.model.service.BRBoardService;
import br.board.model.vo.BRBoard;
import br.board.model.vo.PageData;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/board/boardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String boardWriter = (String)request.getSession().getAttribute("memberId");
//		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		BRBoardService service = new BRBoardService();
//		List<BRBoard> bList = service.selectBoardList(boardWriter);
//		// 네비게이터 만들기
//		PageData pd = service.selectBoardNavi(currentPage);
//		request.setAttribute("bList", bList);
//		request.setAttribute("pageNavi", pd.getPageNavi());
//		request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp").forward(request, response);
//	}
		HttpSession session = request.getSession();
		String boardWriter = (String)request.getSession().getAttribute("memberId");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		BRBoardService service = new BRBoardService();
//		List<BRBoard> bList = service.selectBoardList(boardWriter);
		// 네비게이터 만들기
		PageData pd = service.selectBoardList(currentPage, boardWriter);
		List<BRBoard> bList = pd.getbList();
		request.setAttribute("bList", bList);
		request.setAttribute("pageNavi", pd.getPageNavi());
		request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp").forward(request, response);
	}
	
	/*
	 * 로그인한 유저의 아이디를 받아서 리스트에 로그인 유저의 글 목록만 출력되도록 함
	 * HttpSession session = request.getSession();
	 * String boardWriter = (String)request.getSession().getAttribute("memberId");
	 * List<BRBoard> bList = service.selectBoardList(boardWriter);
	 * 
	 * 목록 밑에 네비게이터를 
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
