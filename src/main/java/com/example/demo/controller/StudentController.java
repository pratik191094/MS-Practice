package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stu")
public class StudentController {

	@Autowired
	private StudentService service;

	// to store student details
	@PostMapping(value = "/saveInfo")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO dto) {

		StudentDTO studentDTO = service.saveStudent(dto);
		return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);

	}

	// fetch student details by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Integer id) {

		StudentDTO studentDTO = service.getStudentById(id);
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);

	}

	// get all students details
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<StudentDTO>> getAllStudentData() {

		return new ResponseEntity<>(service.getAllStudentData(), HttpStatus.OK);
	}

	// update student details
	@PutMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> updateStudentById(@RequestBody StudentDTO dto, @PathVariable("id") Integer id) {

		return new ResponseEntity<>(service.updateStudentById(dto, id), HttpStatus.OK);
	}
	
	
	// delete student details by id
//		@DeleteMapping(value = "/{id}")
//		public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id) {
//
//			service.deleteStudentById(id);
//			return new ResponseEntity<>(Map.of("message","user deleted successully"), HttpStatus.OK);
//
//		}
}
