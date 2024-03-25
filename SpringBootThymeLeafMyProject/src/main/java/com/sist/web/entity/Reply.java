package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reply {
	@Id
	private int no;
	
	@Column(insertable=true, updatable=false)
	private int fno;
	
	@Column(insertable=true, updatable=false)
	private String id;
	
	@Column(insertable=true, updatable=false)
	private String name;
	
	private String msg;
	
	@Column(insertable=true, updatable=false)
	private String regdate;
}
