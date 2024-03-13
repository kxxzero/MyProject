package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{
	@Query(value="SELECT * FROM book "
			+ "WHERE title LIKE CONCAT('%',:title,'%') "
			+ "ORDER BY no ASC LIMIT :start, 12", nativeQuery=true)
	public List<Book> bookFindList(@Param("start") Integer start, @Param("title") String title);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM book "
			+ "WHERE title LIKE CONCAT('%',:title,'%')", nativeQuery=true)
	public int bookFindTotalPage(@Param("title") String title);
	
	// 찾기 => 상세보기
	public Book findByNo(int no);
	
	
}
