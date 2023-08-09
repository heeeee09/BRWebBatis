package br.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import br.member.model.vo.BRMember;

public class BRMemberDAO {

	public int insertMember(SqlSession session, BRMember member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	public int deleteMember(SqlSession session, BRMember mOne) {
		int result = session.delete("MemberMapper.deleteMember", mOne);
		return result;
	}

	public int oneMemberModify(SqlSession session, BRMember memberEdit) {
		int result = session.update("MemberMapper.oneMemberModify", memberEdit);
		return result;
	}

	public BRMember checkLogin(SqlSession session, BRMember member) {
		BRMember mOne = session.selectOne("MemberMapper.checkLogin", member);
		return mOne;
	}

	public BRMember checkPassword(SqlSession session, BRMember mOne) {
		BRMember member = session.selectOne("MemberMapper.checkPassword", mOne);
		return member;
	}

	public BRMember findId(SqlSession session, BRMember member) {
		BRMember result = session.selectOne("MemberMapper.findId", member);
		return result;
	}

	public BRMember findPw(SqlSession session, BRMember member) {
		BRMember result = session.selectOne("MemberMapper.findPw", member);
		return result;
	}

	public int resetPw(SqlSession session, BRMember member) {
		int result = session.update("MemberMapper.resetPw", member);
		return result;
	}


}
