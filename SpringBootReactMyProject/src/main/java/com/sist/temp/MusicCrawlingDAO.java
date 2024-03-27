package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MusicCrawlingDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:mysql://localhost:3306/mydb?autoReconnection=true";
	
	public MusicCrawlingDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception ex) {}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "root", "root");
		} catch (Exception ex) {}
	}
	
	public void disConnection() {
		try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception ex) {}
	}
	
	public void musicInsert(MusicCrawlingVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO music(title, singer, album, poster, state, idcrement) "
					 + "VALUES(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getSinger());
			ps.setString(3, vo.getAlbum());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getState());
			ps.setInt(6, vo.getIdcrement());
			
			// 데이터베이스에 저장
			ps.executeUpdate();
		} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		disConnection();
    	}
	}
	
}
