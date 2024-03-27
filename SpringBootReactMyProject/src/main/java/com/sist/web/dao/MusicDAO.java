package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Music;

public interface MusicDAO extends JpaRepository<Music, Integer>{
	@Query(value="SELECT * FROM music ORDER BY no ASC LIMIT 9", nativeQuery=true)
	public List<Music> musicMainData();
	
	@Query(value="SELECT * FROM music ORDER BY no ASC LIMIT :start, 12", nativeQuery=true)
	public List<Music> musicListData(@Param("start") int start);
	
}
