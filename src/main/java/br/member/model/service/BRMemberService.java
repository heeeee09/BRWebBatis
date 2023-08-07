package br.member.model.service;

import org.apache.ibatis.session.SqlSession;

import br.member.model.dao.BRMemberDAO;
import br.member.model.vo.BRMember;
import common.SqlSessionTemplate;

public class BRMemberService {
	
	private BRMemberDAO bDao;
	
	public BRMemberService() {
		bDao = new BRMemberDAO();
	}
	
	public int insertMember(BRMember member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = bDao.insertMember(session, member);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int oneMemberModify(BRMember memberEdit) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = bDao.oneMemberModify(session, memberEdit);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteMember(String memberId, BRMember mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = bDao.deleteMember(session, mOne);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public BRMember checkLogin(BRMember member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		BRMember mOne = bDao.checkLogin(session, member);
		session.close();
		return mOne;
	}

	public Boolean userCheck(BRMember mOne) {
		// 저장된 정보가 있으면 true 리턴, 없으면 false 리턴
		SqlSession session = SqlSessionTemplate.getSqlSession();
		BRMember check = bDao.checkPassword(session, mOne);
		if(check != null) {
			return true;
		} else {
			return false;
		}
	}

}
