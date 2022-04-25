package com.sebin.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	private String emp_id;
	private String emp_nm;
	private String teleno;
	private String road_nm;
	private String dept_id;
	private String dept_nm;
	private String up_dept_id;
	private String hobby_id;
	private String hobby_nm;


	
	
		
}