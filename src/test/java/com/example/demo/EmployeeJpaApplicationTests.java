package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeJpaApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void CreateTest() {
		Employee employee = new Employee();
		employee.setCode(31);
		employee.setAge(1);
		employee.setName("aaa");
		employee.setSection("afsf");
		employeeService.Create(employee);
	}
	
	//OK
	@Test
	public void SaveTest() {
		Employee employee = new Employee();
		employee.setCode(201042);
		employee.setAge(1);
		employee.setName("aaa");
		employee.setSection("afsf");
		employeeService.Save(employee);
	}
	
	//OK
	@Test
	public void DeleteTest() {
		employeeService.Delete(201024);
	}
}

