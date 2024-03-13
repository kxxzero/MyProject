package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
NO int 
TITLE text 
POSTER text 
CONT text 
HIT int 
ADDR text 
PHONE text 
BHOUR text 
RATE text 
DEIMAGE text 
TAG text 
HEART int 
JJIM int
 */

@Entity
@Data
public class Tour {
	@Id
	private int no;
	
	private String title, poster, cont, addr, phone, bhour, rate, deimage, tag;
	private int hit, heart, jjim;
}
