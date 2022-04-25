package com.sebin.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sebin.project.model.Employee;
import com.sebin.project.service.EmpService;


@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	EmpService empService;

	
	@RequestMapping("/")
	public String goH() {
		
		return "content/home";
	}
	
	@RequestMapping(value ="/search", method = RequestMethod.GET)
	public ModelAndView goHome(Model model,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		String emp_nm = request.getParameter("emp_nm");
		
		List<Employee> employeeList = empService.getEmpInfo(emp_nm);
		List<Employee> deptList = empService.getDeptInfo();
		List<Employee> hobbyList = empService.getHobbyNm();
		mav.addObject("employeeList", employeeList);
		mav.addObject("deptList", deptList);
		mav.addObject("hobbyList", hobbyList);
		mav.setViewName("content/home");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value ="/detail", method = {RequestMethod.POST,RequestMethod.GET})
	public List<Employee> getDetailInfo(Model model,HttpServletRequest request, Employee employee) {
		
		List<Employee> employeeList = empService.getDetailInfo(employee);
		return employeeList;
	}

	@RequestMapping(value ="/register", method = {RequestMethod.POST,RequestMethod.GET})
	public String regiEmp(Model model,HttpServletRequest request, Employee employee) {
		String empNm = employee.getEmp_nm().replace(",", "");
		employee.setEmp_nm(empNm);
		
		Map<String, String> emp = new HashMap<>();
		emp.put("emp_id", employee.getEmp_id());
		emp.put("emp_nm", employee.getEmp_nm());
		emp.put("teleno", employee.getTeleno());
		emp.put("road_nm", employee.getRoad_nm());
		emp.put("dept_id", employee.getDept_id());
		empService.regiEmp(emp);
		
		String hobbyId = employee.getHobby_id();
		String[] hobbyList = hobbyId.split(",");
		
		for(int i=0; i<hobbyList.length; i++) {
			Map<String, String> hobby = new HashMap<>();
			employee.setHobby_id(hobbyList[i]);
			hobby.put("emp_id", employee.getEmp_id());
			hobby.put("hobby_id", employee.getHobby_id());
			empService.regiHobby(hobby);
		}
		return "redirect:/home/";
	}
	
	@RequestMapping(value ="/deleteInfo", method = {RequestMethod.POST,RequestMethod.GET})
	public String deleteEmp(Model model,HttpServletRequest request, Employee employee) {
		String emp_id = request.getParameter("emp_id");
		empService.deleteEmp(emp_id);
		return "redirect:/home/";
	

	}

	@RequestMapping(value ="/update", method = {RequestMethod.POST,RequestMethod.GET})
	public String update(Model model,HttpServletRequest request, Employee employee) {


		String empNm = employee.getEmp_nm().replace(",", "");
		employee.setEmp_nm(empNm);
		
		Map<String, String> emp = new HashMap<>();
		emp.put("emp_id", employee.getEmp_id());
		emp.put("emp_nm", employee.getEmp_nm());
		emp.put("teleno", employee.getTeleno());
		emp.put("road_nm", employee.getRoad_nm());
		emp.put("dept_id", employee.getDept_id());
		empService.update(emp);
		
		String hobbyId = employee.getHobby_id();
		String[] hobbyList = hobbyId.split(",");
		
		empService.deleteEmpHobby(emp);
		for(int i=0; i<hobbyList.length; i++) {
			Map<String, String> hobby = new HashMap<>();
			employee.setHobby_id(hobbyList[i]);
			hobby.put("emp_id", employee.getEmp_id());
			hobby.put("hobby_id", employee.getHobby_id());
			empService.regiHobby(emp);
			
		}
		return "redirect:/home/";
	

	}

	
	
}
