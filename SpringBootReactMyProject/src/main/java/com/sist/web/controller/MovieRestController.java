package com.sist.web.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MovieRestController {
	@GetMapping("/movie/movie_boot")
	public String movie_data(int no) {
		String site = "";
		if (no == 1) {
			site = "searchMainDailyBoxOffice.do";
		} else if (no == 2) {
			site = "searchMainRealTicket.do";
		} else if (no == 3) {
			site = "searchMainDailySeatTicket.do";
		}
		String strUrl = "https://www.kobis.or.kr/kobis/business/main/" + site;
		String result = "";
		try {
			// Document doc=Jsop.connection().get()
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				while (true) {
					String data = br.readLine();
					if (data == null)
						break;
					result += data;
				}
			}
		} catch (Exception ex) {}
		return result;
	}
}
