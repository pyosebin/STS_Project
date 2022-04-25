package com.sebin.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebin.project.mapper.EmpMapper;
import com.sebin.project.model.Employee;

@Service
public class EmpService {

	@Autowired
	public EmpMapper empMapper;
	
	//private SqlSessionFactory sqlSessionFactory;
	
	
	public List<Employee> getEmpInfo(String emp_nm){
		return empMapper.getEmpInfo(emp_nm);
		
	}
	
	public List<Employee> getDetailInfo(Employee emp){
		return empMapper.getDetailInfo(emp);
		
	}

	public List<Employee> getDeptInfo(){
		return empMapper.getDeptInfo();
				
	}
	
	public List<Employee> getHobbyNm(){
		return empMapper.getHobbyNm();
	}

	public Integer regiEmp(Map<String, String> emp) {
		return empMapper.regiEmp(emp);
	}
	
	public Integer regiHobby(Map<String, String> emp) {
		return empMapper.regiHobby(emp);
	
	}
	public Integer deleteEmp(String emp_id) {
		return empMapper.deleteEmp(emp_id);
		
	}
	
//	public List<Employee> getEmpInfo2(String emp_id){
//		return empMapper.getEmpInfo2(emp_id);
//		
//	}
	
	
}