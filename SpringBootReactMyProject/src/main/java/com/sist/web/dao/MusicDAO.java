package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Music;

public interface MusicDAO extends JpaRepository<Music, Integer> {
	@Query(value = "SELECT * FROM music "
			+ "ORDER BY no ASC "
			+ "LIMIT 10", nativeQuery = true)
	public List<Music> musicMainData();

	@Query(value = "SELECT * FROM music "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 20", nativeQuery = true)
	public List<Music> musicListData(@Param("start") int start);

	@Query(value = "SELECT * FROM music " 
			+ "WHERE title LIKE CONCAT('%',:title,'%') "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 20", nativeQuery = true)
	public List<Music> musicFindData(@Param("start") Integer start, @Param("title") String title);

	@Query(value = "SELECT COUNT(*) FROM music "
			+ "WHERE title LIKE CONCAT('%',:title,'%') ", nativeQuery = true)
	public int musicFindTotalPage(@Param("title") String title);
}
