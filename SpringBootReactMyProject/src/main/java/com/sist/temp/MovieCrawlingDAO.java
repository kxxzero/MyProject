package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MovieCrawlingDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:mysql://localhost:3306/mydb?autoReconnection=true";
	
	public MovieCrawlingDAO() {
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
	
	public void movieInsert(MovieCrawlingVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO movie(subject, poster, genre, rtime, rdate, actor, grade) "
					 + "VALUES(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getPoster());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getRtime());
			ps.setString(5, vo.getRdate());
			ps.setString(6, vo.getActor());
			ps.setString(7, vo.getGrade());
			
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
