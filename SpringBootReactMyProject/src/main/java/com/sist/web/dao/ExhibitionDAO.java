package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Exhibition;

public interface ExhibitionDAO extends JpaRepository<Exhibition, Integer>{
	@Query(value = "SELECT * FROM exhibition ORDER BY eno DESC LIMIT 8", nativeQuery = true)
	public List<Exhibition> exhibitionMainData();

	@Query(value = "SELECT * FROM exhibition ORDER BY eno DESC LIMIT :start, 12", nativeQuery = true)
	public List<Exhibition> exhibitionListData(@Param("start") int start);
	
	@Query(value = "SELECT * FROM exhibition " 
			+ "WHERE ename LIKE CONCAT('%',:ename,'%') "
			+ "ORDER BY eno DESC LIMIT :start, 12", nativeQuery = true)
	public List<Exhibition> exhibitionFindData(@Param("start") Integer start, @Param("ename") String ename);

	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM exhibition "
			+ "WHERE ename LIKE CONCAT('%',:ename,'%') ", nativeQuery = true)
	public int exhibitionFindTotalPage(@Param("ename") String ename);
	
	public Exhibition findByEno(int eno);
	
	@Query(value = "SELECT * FROM exhibition ORDER BY RAND() LIMIT 9", nativeQuery = true)
	public List<Exhibition> exhibitionRandData();
}
