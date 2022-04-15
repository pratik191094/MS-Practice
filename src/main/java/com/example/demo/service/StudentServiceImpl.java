package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import com.example.demo.util.Utility;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Autowired
	private Utility util;

	@Override
	public StudentDTO saveStudent(StudentDTO dto) {
		StudentEntity studentEntity = util.convertDTOToEntity(dto);
		StudentEntity save = repo.save(studentEntity);
		StudentDTO studentDtos = util.convertEntitytoDTO(save);
		return studentDtos;
	}

	@Override
	public StudentDTO getStudentById(Integer id) {
		StudentEntity studentEntity = repo.findById(id).get();
		return util.convertEntitytoDTO(studentEntity);

	}

	@Override
	public List<StudentDTO> getAllStudentData() {
		List<StudentEntity> studentEntities = repo.findAll();
		List<StudentDTO> studentDtos = studentEntities.stream().map(stuEntity -> util.convertEntitytoDTO(stuEntity))
				.collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDTO updateStudentById(StudentDTO dto, Integer id) {
		StudentEntity studentEntity = repo.findById(id).get();
		studentEntity.setCity(dto.getCity());
		studentEntity.setName(dto.getName());
		StudentEntity save = repo.save(studentEntity);
		return util.convertEntitytoDTO(save);

	}

	@Override
	public void deleteStudentById(Integer id) {
		repo.deleteById(id);
		
	}

}
