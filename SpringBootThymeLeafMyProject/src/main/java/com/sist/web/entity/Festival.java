package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
NO int 
TITLE text 
POSTER text 
DEIMAGE text 
CONT text 
HIT int 
ADDR text 
RATE text 
PHONE text 
BHOUR text 
TAG text 
HEART int 
JJIM int
 */

@Entity
@Data
public class Festival {
	@Id
	private int no;
	
	private int hit, heart, jjim;
	private String title, poster, deimage, cont, addr, rate, phone, bhour, tag;
}
