package br.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import br.board.model.vo.BRBoard;

public class BRBoardDAO {
	
	public int boardInsert(Connection conn, BRBoard board) {
		String query = "INSERT INTO BR_CUSTOMOR_BOARD_TBL VALUES(SEQ_CUSTOMOR_BOARD_NO.NEXTVAL,?,?,DEFAULT,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardSubject());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

//	public List<BRBoard> selectList(Connection conn, String boardWriter) {
//		String query = "SELECT CUSTOMOR_BOARD_DATE, CUSTOMOR_BOARD_SUBJECT FROM BR_CUSTOMOR_BOARD_TBL INNER JOIN BR_MEMBER_TBL "
//				+ "ON CUSTOMOR_BOARD_WRITER = MEMBER_ID WHERE CUSTOMOR_BOARD_WRITER = ?";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		List<BRBoard> bList = new ArrayList<BRBoard>(); 
//		BRBoard board = null;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, boardWriter);
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				board = new BRBoard();
//				board.setBoardDate(rset.getString("CUSTOMOR_BOARD_DATE"));
//				board.setBoardSubject(rset.getString("CUSTOMOR_BOARD_SUBJECT"));
////				board.setBoardContent(rset.getString("CUSTOMOR_BOARD_CONTENT"));
//				bList.add(board);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bList;
//	}

	public List<BRBoard> selectBoardList(SqlSession session, int currentPage, String boardWriter) {
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY CUSTOMOR_BOARD_NO DESC) "
				+ "ROW_NUM, CUSTOMOR_BOARD_DATE, CUSTOMOR_BOARD_SUBJECT FROM BR_CUSTOMOR_BOARD_TBL INNER JOIN BR_MEMBER_TBL "
				+ "ON CUSTOMOR_BOARD_WRITER = MEMBER_ID WHERE CUSTOMOR_BOARD_WRITER = ?) WHERE ROW_NUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BRBoard> bList = new ArrayList<BRBoard>(); 
		BRBoard board = null;
		int recordCountPerPage = 5;		// 페이지당 보여줄 글 수
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);	// 표시되는 게시글 시작
		int end = currentPage*recordCountPerPage;		// 표시되는 게시글 끝
		try {
			pstmt = session.prepareStatement(query);
			pstmt.setString(1, boardWriter);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				board = new BRBoard();
				board.setBoardDate(rset.getString("CUSTOMOR_BOARD_DATE"));
				board.setBoardSubject(rset.getString("CUSTOMOR_BOARD_SUBJECT"));
//				board.setBoardContent(rset.getString("CUSTOMOR_BOARD_CONTENT"));
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	public String generatePageNavi(int currentPage) {
		int totalCount = 8;		// 전체 글 수
		int recordCountPerPage = 5;		// 페이지당 보여줄 글 수
		int naviTotalCount = 0;		// 네비게이터 갯수
		if(totalCount % recordCountPerPage > 0) { // 나머지가 있으면, 전체글/페이지당 출력하는 글 수 = 0보다 크면(나머지가 있으면)
			// 네비 전체 갯수 = 전체글 / 게시글 출력 갯수 + 1
			naviTotalCount = totalCount / recordCountPerPage + 1;
		}else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5;	// 네비게이터에 표시되는 숫자 한도
		// 네비게이터 시작 숫자 = ((표시될 페이지 수 -1)/네비게이터 숫자 한도) * 네비게이터 숫자 한도 +1
		/*
		 * 									1-1 / 5 * 5 +1 = 0 / 5 * 5 + 1 = 1
		 * 									2-1/ 5 -> 0.2 * 5 = 1 +1 => 2
		 * 									3-1/5 -> 0.4 *5 = 2 + 1 => 3하...
		 */
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage +1;
		// 			시작 숫자 + 표시되는 숫자 한도 -1
		int endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == naviTotalCount) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		// 이전 페이지가 존재/다음 페이지가 존재하면 a태그 생성
		if(needPrev) {
			result.append("<a href='/board/boardList.do?currentPage="+(startNavi-1)+">'[이전]</a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/board/boardList.do?currentPage="+i+"'>"+i+"</a>&nbsp&nbsp");
		}
		if(needNext) {
			result.append("<a href='/board/boardList.do?currentPage="+(endNavi+1)+">'[다음]</a>");
		}
		return result.toString();
	}
}
