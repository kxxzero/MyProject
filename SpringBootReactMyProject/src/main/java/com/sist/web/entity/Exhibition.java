package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exhibition {
	@Id
	private int eno;
	private int elike, hit, jjim, price;
	private String ename, eename, efield, eitem, cate, homepage, s_date, e_date, loc, loc_detail, host, poster, rday;
	private double score;

}
