package com.think.learn_springboot.controller;

import com.think.learn_springboot.dto.StudentResponseDTO;
import com.think.learn_springboot.entity.Student;
import com.think.learn_springboot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){
       return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public  StudentResponseDTO findStudentById(@PathVariable("id") UUID id){
        return studentService.findStudentById(id);
    }

    @PostMapping("/students")
    public StudentResponseDTO addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public StudentResponseDTO updateStudent(@PathVariable("id") UUID id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
