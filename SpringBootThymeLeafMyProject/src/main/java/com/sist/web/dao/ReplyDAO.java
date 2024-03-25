package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Reply;

public interface ReplyDAO extends JpaRepository<Reply, Integer>{
	// 데이터 읽기
	@Query(value="SELET * "
			+ "FROM reply "
			+ "WHERE fno=:fno "
			+ "ORDER BY fno DESC", nativeQuery=true)
	public List<Reply> replyListData(@Param("fno") int fno);
	
	public Reply findByNo(int no);
	// insert, update, delete
}
