package com.think.learn_springboot.service;

import com.think.learn_springboot.dto.StudentResponseDTO;
import com.think.learn_springboot.entity.Profile;
import com.think.learn_springboot.entity.Student;
import com.think.learn_springboot.error.StudentNotFoundException;
import com.think.learn_springboot.mapper.StudentMapper;
import com.think.learn_springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public List<StudentResponseDTO> getAllStudents(){
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();

        List<Student> students = studentRepository.findAll();
        for (Student student:students){
            StudentResponseDTO dto = new StudentResponseDTO();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setProfile(StudentMapper.toProfileDTO(student.getProfile()));
            dto.setCourses(studentMapper.toCourseDTOList(student.getCourses()));

            studentResponseDTOS.add(dto);
        }
        return  studentResponseDTOS;
    }

    public StudentResponseDTO findStudentById(UUID id) {
         Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student with specified id is not present"));
         StudentResponseDTO dto = new StudentResponseDTO();
         dto.setId(student.getId());
         dto.setName(student.getName());
         dto.setEmail(student.getEmail());
         dto.setProfile(studentMapper.toProfileDTO(student.getProfile()));
         dto.setCourses(studentMapper.toCourseDTOList(student.getCourses()));
         return  dto;
    }

    public StudentResponseDTO saveStudent(Student student){

        Student savedStudent = studentRepository.save(student);
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(savedStudent.getId());
        dto.setName(savedStudent.getName());
        dto.setEmail(savedStudent.getEmail());
        dto.setProfile(studentMapper.toProfileDTO(student.getProfile()));
        dto.setCourses(studentMapper.toCourseDTOList(student.getCourses()));
        return  dto;
    }

    public void deleteStudent(UUID id){
        studentRepository.deleteById(id);
    }

    public StudentResponseDTO updateStudent(UUID id, Student student){
        Student targetStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student with specified id is not present"));
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setProfile(studentMapper.toProfileDTO(student.getProfile()));
        dto.setCourses(studentMapper.toCourseDTOList(student.getCourses()));
        return dto;
    }
}
