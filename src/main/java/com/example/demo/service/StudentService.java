package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDTO;

public interface StudentService {

	public StudentDTO saveStudent(StudentDTO dto);

	public StudentDTO getStudentById(Integer id);

	public List<StudentDTO> getAllStudentData();

	public StudentDTO updateStudentById(StudentDTO dto, Integer id);
	
	public void deleteStudentById(Integer id);

}
