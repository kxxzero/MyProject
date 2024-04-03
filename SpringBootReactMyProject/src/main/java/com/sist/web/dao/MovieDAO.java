package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer>{
	@Query(value = "SELECT * FROM movie ORDER BY no ASC LIMIT 8", nativeQuery = true)
	public List<Movie> movieMainData();

	@Query(value = "SELECT * FROM movie ORDER BY no ASC LIMIT :start, 12", nativeQuery = true)
	public List<Movie> movieListData(@Param("start") int start);
	
	@Query(value = "SELECT * FROM movie " 
			+ "WHERE subject LIKE CONCAT('%',:subject,'%') "
			+ "ORDER BY no ASC LIMIT :start, 12", nativeQuery = true)
	public List<Movie> movieFindData(@Param("start") Integer start, @Param("subject") String subject);

	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM movie "
			+ "WHERE subject LIKE CONCAT('%',:subject,'%') ", nativeQuery = true)
	public int movieFindTotalPage(@Param("subject") String subject);
	
	public Movie findByNo(int no);
	
	@Query(value = "SELECT * FROM movie ORDER BY RAND() LIMIT 9", nativeQuery = true)
	public List<Movie> movieRandData();
}
