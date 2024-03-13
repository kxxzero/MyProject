package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
id varchar(20) PK 
pwd varchar(10) 
name varchar(50)
 */

@Entity(name="member")
@Getter
@Setter
@NoArgsConstructor
public class Member {
	@Id
	@Column(name="id", unique=true)
	private String id;
	
	private String pwd;
	private String name;
}
