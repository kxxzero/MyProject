package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Board;
import com.sist.web.entity.Book;

@Service
public interface BoardService extends JpaRepository<Board, Integer>{
	@Query(value="SELECT * FROM board "
			+ "ORDER BY no DESC LIMIT 0, 3", nativeQuery=true)
	public List<Board> boardMainData();
	
	@Query(value="SELECT * FROM board "
			+ "ORDER BY no DESC LIMIT :start, 10", nativeQuery=true)
	public List<Board> boardListData(@Param("start") int start);
	
	public Board findByNo(int no);
	
	// 총 페이지 => count
	// 수정/추가 => save()
	// 삭제 => delete()
}
