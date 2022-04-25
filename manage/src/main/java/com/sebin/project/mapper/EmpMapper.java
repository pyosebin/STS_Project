package com.sebin.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sebin.project.model.Employee;


@Repository
@Mapper
public interface EmpMapper {
	List<Employee> getEmpInfo(String emp_nm); 

	List<Employee> getDetailInfo(Employee emp); 
	
	List<Employee> getDeptInfo();
 
	List<Employee> getHobbyNm();
	
	Integer regiEmp(Map<String, String> emp);

	Integer regiHobby(Map<String, String> emp);
	
	Integer deleteEmp(String emp_id);
	
	Integer update(Map<String, String> emp);
	
	Integer deleteEmpHobby(Map<String, String> emp);
	

}


