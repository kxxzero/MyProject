package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Board;

public interface BoardDAO extends JpaRepository<Board, Integer>{	
	@Query(value="SELECT * "
			+ "FROM board "
			+ "ORDER BY no DESC "
			+ "LIMIT :start, 10", nativeQuery=true)
	public List<Board> boardListData(@Param("start") int start);
	
	public Board findByNo(int no); // sql 문장 없이 메소드만 작성해도 값을 가져옴	
}
