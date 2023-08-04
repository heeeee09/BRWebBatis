package br.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import br.board.model.vo.BRBoard;
import br.member.model.vo.BRMember;

public class BRMemberDAO {

	public int insertMember(SqlSession session, BRMember member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	public int deleteMember(Connection conn, String memberId, String memberPw) {
		String query = "DELETE FROM BR_MEMBER_TBL WHERE MEMBER_ID=? AND MEMBER_PWD=?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public int oneMemberModify(Connection conn, BRMember memberEdit) {
		String query = "UPDATE BR_MEMBER_TBL SET MEMBER_PWD=?, MEMBER_EMAIL=?, MEMBER_PHONE=?, MEMBER_ADDRESS=? WHERE MEMBER_ID=?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberEdit.getMemberPw());
			pstmt.setString(2, memberEdit.getMemberEmail());
			pstmt.setString(3, memberEdit.getMemberPhone());
			pstmt.setString(4, memberEdit.getMemberAddress());
			pstmt.setString(5, memberEdit.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public BRMember checkLogin(SqlSession session, BRMember member) {
		BRMember mOne = session.selectOne("MemberMapper.checkLogin", member);
		return mOne;
	}
	
	public BRMember checkPassword(Connection conn, String memberId, String pwCheck) {
		String query = "SELECT * FROM BR_MEMBER_TBL WHERE MEMBER_ID=? AND MEMBER_PWD=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BRMember mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, pwCheck);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mOne;
	}

	public BRMember rsetToMember(ResultSet rset) throws SQLException {
		BRMember member = new BRMember();
		member.setMemberId(rset.getString("MEMBER_ID"));
		member.setMemberPw(rset.getString("MEMBER_PWD"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setMemberBirth(rset.getString("MEMBER_BIRTHDAY"));
		member.setMemberGender(rset.getString("MEMBER_GENDER"));
		member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
		member.setMemberPhone(rset.getString("MEMBER_PHONE"));
		member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
		return member;
	}


}
