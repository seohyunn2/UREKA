package com.uplus.ureka.member.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.uplus.ureka.member.model.dto.Member;

public interface MemberDao {
	/**
	 * 입력된 id/pass 기반으로 User를 조회해서 반환한다.
	 * @param id
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	Member search(String id) throws SQLException;
	void regist(Member user) throws SQLException;
	void update(Member user) throws SQLException;
	void remove(Member id) throws SQLException;
}
