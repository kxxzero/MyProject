package com.sist.temp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MovieCrawling {
	public static void main(String[] args) {
		
		try {
			// 데이터베이스
			MovieCrawlingDAO dao=new MovieCrawlingDAO();
			
			// Jsoup으로 HTML 파싱
			Document doc=Jsoup.connect("https://dtryx.com/movie/list.do?cgid=FE8EF4D2-F22D-4802-A39A-D58F23A29C1E").get();
			
			Elements subject=doc.select(".movie-list .item .info .subj");
			Elements poster=doc.select(".movie-list .item .thum img");
	    	Elements genre=doc.select(".movie-list .item .info .etc > span:first-child");
	    	Elements rtime=doc.select(".movie-list .item .info .etc > span:nth-child(2)");
	    	Elements rdate=doc.select(".movie-list .item .info .etc > span:last-child");
	    	Elements actor=doc.select(".movie-list .item .info .actor");
	    	Elements grade=doc.select(".movie-list .item .info .grade strong");
	    	
	    	for(int i=0; i<subject.size(); i++) {
	    		System.out.println("순위:"+(i+1));
	    		System.out.println("제목:"+subject.get(i).text());
	    		System.out.println("이미지:"+poster.get(i).attr("src"));
        		System.out.println("장르:"+genre.get(i).text());
        		System.out.println("러닝타임:"+rtime.get(i).text());
        		System.out.println("개봉일:"+rdate.get(i).text());
        		System.out.println("배우:"+actor.get(i).text());
        		System.out.println("예매율:"+grade.get(i).text());
        		
        		System.out.println("=========================");
        		
        		// MusicVO 객체 생성
        		MovieCrawlingVO vo=new MovieCrawlingVO();
        		// text() 메소드를 통해 텍스트 형태로 데이터 가져오기
        		vo.setSubject(subject.get(i).text());
        		vo.setPoster(poster.get(i).attr("src"));
        		vo.setGenre(genre.get(i).text());
        		vo.setRtime(rtime.get(i).text());
        		vo.setRdate(rdate.get(i).text());
        		vo.setActor(actor.get(i).text());
        		vo.setGrade(grade.get(i).text());
        		// attr() 메소드를 통해 속성 형태로 데이터 가져오기

//        		// 데이터베이스 저장
        		dao.movieInsert(vo);
	    	}
	    	System.out.println("저장 완료");
		} catch(Exception ex) {}
		
	}
}
