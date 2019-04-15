package com.example.demo;

import java.util.Date;
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
	@Autowired
	AttendanceService attendanceService = new AttendanceService();
	
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
	public String edit(Model model,@RequestParam("code")int code) {
		Employee employee = employeeService.FindById(code);
		model.addAttribute("code", employee.getCode());
		model.addAttribute("name", employee.getName());
		model.addAttribute("age", employee.getAge());
		model.addAttribute("section", employee.getSection());
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
	
	@RequestMapping("month")
	public String month(Model model) {
		return "month";
	}
	
	@RequestMapping("detail")
	public String detail(Model model,@RequestParam("code")int code) {
		model.addAttribute("code", code);
		return "detail";
	}
	
	@RequestMapping("begin")
	public String begin(Model model) {
		Attendance attendance = new Attendance();
		Date date = new Date();
		int hour = date.getHours();
		int min = date.getMinutes();
		int sec = date.getSeconds();
		String hourStr = String.valueOf(hour);
		String minStr = String.valueOf(min);
		String secStr = String.valueOf(sec);
		if(hour < 10) {
			hourStr = String.valueOf("0" + hour);
		}
		if(min < 10) {
			minStr = String.valueOf("0" + min);
		}
		if(sec < 10) {
			secStr = String.valueOf("0" + sec);
		}
		attendance.setBegin(hourStr + ":" + minStr + ":" + secStr);
		attendance.setCode(201099);
		attendance.setFinish("00:00:00");
		String message="出勤しました";
		model.addAttribute("message",message);
		attendanceService.Create(attendance);
		return "begin";
	}
	
	@RequestMapping("finish")
	public String finish(Model model) {
		Attendance attendance = new Attendance();
		Date date = new Date();
		int hour = date.getHours();
		int min = date.getMinutes();
		int sec = date.getSeconds();
		String hourStr = String.valueOf(hour);
		String minStr = String.valueOf(min);
		String secStr = String.valueOf(sec);
		if(hour < 10) {
			hourStr = String.valueOf("0" + hour);
		}
		if(min < 10) {
			minStr = String.valueOf("0" + min);
		}
		if(sec < 10) {
			secStr = String.valueOf("0" + sec);
		}
		Attendance oldData = attendanceService.FindById(201099);
		attendance.setCode(201099);
		attendance.setFinish(hourStr + ":" + minStr + ":" + secStr);
		attendance.setBegin(oldData.getBegin());
		String message="退勤しました";
		model.addAttribute("message",message);
		attendanceService.Create(attendance);
		return "begin";
	}
}