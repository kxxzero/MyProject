package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
NO int 
TITLE text 
POSTER text 
CONT text 
ADDR text 
PHONE text 
RESTDAY text 
BHOUR text 
TAG text 
HIT int 
HEART int 
DEIMAGE text 
RATE text 
JJIM int
 */

@Entity
@Data
public class Activity {
	@Id
	private int no;
	
	private String title, poster, cont, addr, phone, restday, bhour, tag, deimage, rate;
	private int hit, heart, jjim;
}
