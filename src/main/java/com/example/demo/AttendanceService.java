package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	// attendanceの新規作成
	public void Create(Attendance attendance) {
		attendanceRepository.saveAndFlush(attendance);
	}
	// attendanceの更新
	public void Save(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
	// attendanceをすべて検索
	public List<Attendance> FindAll(){
		return attendanceRepository.findAll();
	}
	// attendanceを一つ取り出す
	public Attendance FindById(int code) {
		return attendanceRepository.findById(code).orElse(null);
	}
}
