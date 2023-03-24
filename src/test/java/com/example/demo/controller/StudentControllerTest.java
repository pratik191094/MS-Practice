package com.example.demo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentController#saveStudent(StudentDTO)}
     */
    @Test
    void testSaveStudent() throws Exception {
        // Arrange
        when(studentService.saveStudent((StudentDTO) any())).thenReturn(new StudentDTO());

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setCity("Oxford");
        studentDTO.setId(1);
        studentDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(studentDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/stu/saveInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":null,\"name\":null,\"city\":null}"));
    }

    /**
     * Method under test: {@link StudentController#getStudentById(Integer)}
     */
    @Test
    void testGetStudentById() throws Exception {
        // Arrange
        when(studentService.getStudentById((Integer) any())).thenReturn(new StudentDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stu/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":null,\"name\":null,\"city\":null}"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudentData()}
     */
    @Test
    void testGetAllStudentData() throws Exception {
        // Arrange
        when(studentService.getAllStudentData()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stu/getAll");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudentData()}
     */
    @Test
    void testGetAllStudentData2() throws Exception {
        // Arrange
        when(studentService.getAllStudentData()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/stu/getAll");
        getResult.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#updateStudentById(StudentDTO, Integer)}
     */
    @Test
    void testUpdateStudentById() throws Exception {
        // Arrange
        when(studentService.updateStudentById((StudentDTO) any(), (Integer) any())).thenReturn(new StudentDTO());

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setCity("Oxford");
        studentDTO.setId(1);
        studentDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(studentDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/stu/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":null,\"name\":null,\"city\":null}"));
    }
}

