package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

/*  
no int AI PK 
name varchar(51) 
subject varchar(1000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int
*/

@Entity
@Data
@DynamicUpdate
public class Board {
	@Id
	private int no;
	
	private String name;
	private String subject;
	private String content;
	
	@Column(insertable=true, updatable=false)
	private String pwd;
	
	@Column(insertable=true, updatable=false)
	private String regdate;
	
	private int hit;
	
	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
}
