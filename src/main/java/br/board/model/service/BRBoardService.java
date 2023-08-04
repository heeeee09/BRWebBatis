package br.board.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import br.board.model.dao.BRBoardDAO;
import br.board.model.vo.BRBoard;
import br.board.model.vo.PageData;
import common.JDBCTemplate;
import common.SqlSessionTemplate;

public class BRBoardService {
	
	private BRBoardDAO bDao;
	
	public BRBoardService() {
		bDao = new BRBoardDAO();
	}

	public PageData selectBoardList(int currentPage, String boardWriter) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<BRBoard>bList = bDao.selectBoardList(session, currentPage, boardWriter);
		String pageNavi = bDao.generatePageNavi(currentPage);
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

	public PageData selectBoardNavi(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
