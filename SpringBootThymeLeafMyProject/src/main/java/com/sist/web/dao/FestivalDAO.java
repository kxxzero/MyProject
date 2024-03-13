package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Festival;

@Repository
public interface FestivalDAO extends JpaRepository<Festival, Integer>{
	// 메인 출력
	@Query(value="SELECT * "
			+ "FROM festival "
			+ "ORDER BY heart DESC "
			+ "LIMIT 3", nativeQuery=true)
	public List<Festival> mainFestivalData();
	
	// 목록 출력
	@Query(value="SELECT * "
			+ "FROM festival "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Festival> festivalListData(@Param("start") int start);
	
	// 총 페이지
	@Query(value="SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM festival", nativeQuery=true)
	public int festivalRowCount();
	
	// 찾기
	public Festival findByNo(int no);
	
	// 검색
	@Query(value="SELECT * "
			+ "FROM festival "
			+ "WHERE title LIKE CONCAT('%',:title,'%') "
			+ "LIMIT :start, 12", nativeQuery=true)
	public List<Festival> festivalFindData(@Param("start") Integer start, @Param("title") String title);
	
	// 검색 페이지
	@Query(value="SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM festival "
			+ "WHERE title LIKE CONCAT('%',:title,'%')", nativeQuery=true)
	public int festivalFindTotalPage(@Param("title") String title);
}
