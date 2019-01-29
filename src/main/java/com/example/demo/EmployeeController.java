package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService = new EmployeeService();
	
	@RequestMapping("")
	public ModelAndView index(ModelAndView mav) {
		List<Employee> employees = employeeService.FindAll();
		mav.addObject("employees",employees);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("{code}")
	private ModelAndView show(ModelAndView mav,@PathVariable("code")int code) {
		Employee employee = employeeService.FindById(code);
		mav.addObject("employee",employee);
		mav.setViewName("show");
		return mav;
	}
	
	@RequestMapping("{code}")
	private ModelAndView edit(ModelAndView mav,@PathVariable("code")int code) {
		mav.setViewName("edit");
		return mav;
	}
	
	@RequestMapping("edit/result")
	private ModelAndView result(ModelAndView mav,@RequestParam("code")int code,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
		Employee employee = new Employee();
		employee.setCode(code);
		employee.setName(name);
		employee.setAge(age);
		employee.setSection(section);
		employeeService.Save(employee);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping("create")
	private ModelAndView create(ModelAndView mav) {
		mav.setViewName("create");
		return mav;
	}
	
	@RequestMapping("createResult")
	private ModelAndView createResult(ModelAndView mav,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(age);
		employee.setSection(section);
		employeeService.Create(employee);
		mav.addObject("message","新規データを入力しました");
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping("/delete/{code}")
	private ModelAndView delete(ModelAndView mav,@PathVariable("code")int code) {
		employeeService.Delete(code);
		mav.setViewName("result");
		return mav;
	}
	

}