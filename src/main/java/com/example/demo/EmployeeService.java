package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// 従業員データを全て検索
	public List<Employee> FindAll(){
		return employeeRepository.findAll();
	}
	// 個人の従業員データを取り出す
	public Employee FindById(int code) {
		return employeeRepository.findById(code).orElse(null);
	}
	// 従業員を新規作成
	public void Create(Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}
	// 従業員データを更新
	public void Save(Employee employee) {
		employeeRepository.save(employee);
	}
	// 従業員データを削除
	public void Delete(int id) {
	}
}
