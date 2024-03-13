package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Member;

public interface MemberDAO extends JpaRepository<Member, String>{
	@Query(value="SELECT COUNT(*) "
			+ "FROM member "
			+ "WHERE id=:id", nativeQuery=true)
	public int memberIdCount(@Param("id") String id);
	
	@Query(value="SELECT * "
			+ "FROM member "
			+ "WHERE id=:id", nativeQuery=true)
	public Member memberInfoData(@Param("id") String id);
}
