package br.board.model.dao;

import java.util.List;

import javax.management.ValueExp;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import br.board.model.vo.BRBoard;

public class BRBoardDAO {
	
	public int boardInsert(SqlSession session, BRBoard board) {
		int result = session.insert("BoardMapper.boardInsert", board);
		return result;
	}

	public List<BRBoard> selectBoardList(SqlSession session, int currentPage, String boardWriter) {
		int limit = 5;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BRBoard> bList = session.selectList("BoardMapper.selectBoardList", boardWriter, rowBounds);
		return bList;
	}

	public String generatePageNavi(SqlSession session, int currentPage, String boardWriter) {
		int totalCount = session.selectOne("BoardMapper.selectBoardListCount", boardWriter);	// 전체 글 수
//		String count = selectBoardListCount(session);
//		int totalCount = Integer.parseInt(count);
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

	public BRBoard selectOneByNo(SqlSession session, int boardNo) {
		BRBoard board = session.selectOne("BoardMapper.selectOneByNo", boardNo);
		return board;
	}
}
