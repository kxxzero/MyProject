package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Exhibition;

public interface ExhibitionDAO extends JpaRepository<Exhibition, Integer>{
	@Query(value = "SELECT * FROM exhibition ORDER BY eno ASC LIMIT 10", nativeQuery = true)
	public List<Exhibition> exhibitionMainData();

	@Query(value = "SELECT * FROM exhibition ORDER BY eno ASC LIMIT :start, 20", nativeQuery = true)
	public List<Exhibition> exhibitionListData(@Param("start") int start);

	@Query(value = "SELECT * FROM exhibition " 
			+ "WHERE ename LIKE CONCAT('%',:ename,'%') "
			+ "ORDER BY eno ASC LIMIT :start, 20", nativeQuery = true)
	public List<Exhibition> exhibitionFindData(@Param("start") Integer start, @Param("ename") String ename);

	@Query(value = "SELECT CEIL(COUNT(*)/20.0) FROM exhibition "
			+ "WHERE ename LIKE CONCAT('%',:ename,'%') ", nativeQuery = true)
	public int exhibitionFindTotalPage(@Param("ename") String ename);
}
