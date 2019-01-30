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
	
	@RequestMapping("create")
	public ModelAndView create(ModelAndView mav) {
		mav.setViewName("create");
		return mav;
	}
	
	@RequestMapping("result")
	public ModelAndView result(Model model,ModelAndView mav,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
		Employee employee = new Employee();
		// create用
		employee.setName(name);
		employee.setAge(age);
		employee.setSection(section);
		// result表示用
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("section",section);
		employeeService.Create(employee);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping("show")
	public String show(Model model,@RequestParam("code")int code) {
		Employee employee = employeeService.FindById(code);
		model.addAttribute("code", employee.getCode());
		model.addAttribute("name", employee.getName());
		model.addAttribute("age", employee.getAge());
		model.addAttribute("section", employee.getSection());
		return "show";
	}
	
	@RequestMapping("edit")
	public String edit(Model model,@RequestParam("code")int code,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("section", section);
		return "edit";
	}
	
	@RequestMapping("editResult")
	public String editresult(Model model,@RequestParam("code")int code,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
		Employee employee = new Employee();
		employee.setCode(code);
		employee.setName(name);
		employee.setAge(age);
		employee.setSection(section);
		employeeService.Save(employee);
		return "editResult";
	}
	
	@RequestMapping("delete")
	public String delete(Model model,@RequestParam("code")int code) {
		model.addAttribute("code",code);
		employeeService.Delete(code);
		return "delete";
	}

	
//	@RequestMapping("{code}")
//	private ModelAndView show(ModelAndView mav,@PathVariable("code")int code) {
//		Employee employee = employeeService.FindById(code);
//		mav.addObject("employee",employee);
//		mav.setViewName("show");
//		return mav;
//	}
//	
//	@RequestMapping("edit/{code}")
//	private ModelAndView edit(ModelAndView mav,@PathVariable("code")int code) {
//		mav.setViewName("edit");
//		return mav;
//	}
//	
//	@RequestMapping("edit/result")
//	private ModelAndView result(ModelAndView mav,@RequestParam("code")int code,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
//		Employee employee = new Employee();
//		employee.setCode(code);
//		employee.setName(name);
//		employee.setAge(age);
//		employee.setSection(section);
//		employeeService.Save(employee);
//		mav.setViewName("result");
//		return mav;
//	}
//	
//	@RequestMapping("create")
//	private ModelAndView create(ModelAndView mav) {
//		mav.setViewName("create");
//		return mav;
//	}
//	
//	@RequestMapping("createResult")
//	private ModelAndView createResult(ModelAndView mav,@RequestParam("name")String name,@RequestParam("age")int age,@RequestParam("section")String section) {
//		Employee employee = new Employee();
//		employee.setName(name);
//		employee.setAge(age);
//		employee.setSection(section);
//		employeeService.Create(employee);
//		mav.addObject("message","新規データを入力しました");
//		mav.setViewName("result");
//		return mav;
//	}
//	
//	@RequestMapping("/delete/{code}")
//	private ModelAndView delete(ModelAndView mav,@PathVariable("code")int code) {
//		employeeService.Delete(code);
//		mav.setViewName("result");
//		return mav;
//	}
//	

}