package com.sist.web.entity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
NO bigint 
TITLE varchar(500) 
POSTER varchar(1000) 
PUBL varchar(300) 
AUTHOR varchar(200) 
CONTENT varchar(1000) 
SCORE bigint 
BUY_CNT bigint 
HEART bigint 
JJIM bigint 
KEYWORD varchar(1000) 
GENRE varchar(1000) 
B_DATE varchar(100) 
PRICE bigint
 */

@Data
@NoArgsConstructor
public class Book {
	@Id
	private int no;
	private String title, poster, publ, author, content, keyword, genre, b_date;
	private int score, buy_cnt, heart, jjim, price;
}
