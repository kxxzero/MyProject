package com.sist.temp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicCrawling {
	public static void main(String[] args) {
		
		try {
			// 데이터베이스
			MusicCrawlingDAO dao=new MusicCrawlingDAO();
			
			// Jsoup으로 HTML 파싱
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240327&hh=11&rtm=Y&pg=4").get();
			
			Elements title=doc.select("table.list-wrap td.info a.title");
	    	Elements singer=doc.select("table.list-wrap td.info a.artist");
	    	Elements album=doc.select("table.list-wrap td.info a.albumtitle");
	    	Elements poster=doc.select("table.list-wrap a.cover img");
	    	Elements etc=doc.select("table.list-wrap span.rank");
	    	
	    	for(int i=0; i<title.size(); i++) {
	    		System.out.println("순위:"+(i+1));
	    		System.out.println("제목:"+title.get(i).text());
        		System.out.println("가수:"+singer.get(i).text());
        		System.out.println("앨범:"+album.get(i).text());
        		System.out.println("상태:"+etc.get(i).text());
        		System.out.println("이미지:"+poster.get(i).attr("src"));
        		System.out.println("=========================");
        		
        		// MusicVO 객체 생성
        		MusicCrawlingVO vo=new MusicCrawlingVO();
        		// text() 메소드를 통해 텍스트 형태로 데이터 가져오기
        		vo.setTitle(title.get(i).text());
        		vo.setSinger(singer.get(i).text());
        		vo.setAlbum(album.get(i).text());
        		// attr() 메소드를 통해 속성 형태로 데이터 가져오기
        		vo.setPoster(poster.get(i).attr("src"));
        		
        		String s=etc.get(i).text();
        		String id="";
        		String state="";
        		
        		if(s.equals("유지")) {
        			id="0";
        			state="유지";
        		} else {
        			// 숫자 및 한글 외의 문자 제거
        			id=s.replaceAll("[^0-9]",""); // 정규표현식
        			state=s.replaceAll("[^가-힣]", "");
        		}
        		vo.setIdcrement(Integer.parseInt(id.trim()));
        		vo.setState(state);
        		
        		// 데이터베이스 저장
        		dao.musicInsert(vo);
	    	}
	    	System.out.println("저장 완료");
		} catch(Exception ex) {}
		
	}
}
