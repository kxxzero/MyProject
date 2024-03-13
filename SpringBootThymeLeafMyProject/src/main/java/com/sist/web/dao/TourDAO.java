package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Tour;

@Repository
public interface TourDAO extends JpaRepository<Tour, Integer>{
	// 메인 출력
	@Query(value="SELECT * "
			+ "FROM tour "
			+ "ORDER BY heart DESC "
			+ "LIMIT 3", nativeQuery=true)
	public List<Tour> mainTourData();
	
	// 목록 출력
	@Query(value="SELECT * "
			+ "FROM tour "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Tour> tourListData(@Param("start") int start);
	
	// 총 페이지
	@Query(value="SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM tour", nativeQuery=true)
	public int tourRowCount();
	
	// 찾기
	public Tour findByNo(int no);
	
	// 검색
	@Query(value="SELECT * "
			+ "FROM tour "
			+ "WHERE title LIKE CONCAT('%',:title,'%') "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Tour> tourFindData(@Param("start") Integer start, @Param("title") String title);
	
	// 검색 페이지
	@Query(value="SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM tour "
			+ "WHERE title LIKE CONCAT('%',:title,'%')", nativeQuery=true)
	public int tourFindTotalPage(@Param("title") String title);
}
