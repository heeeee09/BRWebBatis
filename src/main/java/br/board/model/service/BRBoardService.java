package br.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.SqlTimestampTypeHandler;

import br.board.model.dao.BRBoardDAO;
import br.board.model.vo.BRBoard;
import br.board.model.vo.PageData;
import common.SqlSessionTemplate;

public class BRBoardService {
	
	private BRBoardDAO bDao;
	
	public BRBoardService() {
		bDao = new BRBoardDAO();
	}

	public PageData selectBoardList(int currentPage, String boardWriter) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<BRBoard>bList = bDao.selectBoardList(session, currentPage, boardWriter);
		String pageNavi = bDao.generatePageNavi(session, currentPage, boardWriter);
		PageData pd = new PageData(bList, pageNavi);
		session.close();
		return pd;
	}
	
	public int boardInsert(BRBoard board) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = bDao.boardInsert(session, board);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
//	public void selectBoardListCount() {
//		SqlSession session = SqlSessionTemplate.getSqlSession();
//		int count = bDao.selectBoardListCount(session);
//	}

	public PageData selectBoardNavi(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public BRBoard selectOneByNo(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		BRBoard board = bDao.selectOneByNo(session, boardNo);
		session.close();
		return board;
	}

}
