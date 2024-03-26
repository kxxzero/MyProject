package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Member;

@Repository
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
