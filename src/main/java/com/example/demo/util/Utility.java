package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;

@Configuration
public class Utility {

	@Autowired
	private ModelMapper modelMapper;

	public StudentEntity convertDTOToEntity(StudentDTO dto) {

		StudentEntity entity = modelMapper.map(dto, StudentEntity.class);
		return entity;

	}

	public StudentDTO convertEntitytoDTO(StudentEntity entity) {

		StudentDTO dto = modelMapper.map(entity, StudentDTO.class);
		return dto;

	}

//	public List<StudentDTO> convertEntitiestoDTO(List<StudentEntity> entities) {
//
//		List<StudentDTO> dtos = null;
//		for (StudentEntity entity : entities) {
//			dtos = new ArrayList<>();
//			StudentDTO dto = modelMapper.map(entity, StudentDTO.class);
//			dtos.add(dto);
//		}
//		return dtos;
//
//	}
}
