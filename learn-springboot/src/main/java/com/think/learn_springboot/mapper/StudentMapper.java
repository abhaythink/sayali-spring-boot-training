package com.think.learn_springboot.mapper;

import com.think.learn_springboot.dto.*;
import com.think.learn_springboot.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        //student.setProfile();
        //student.setCourses(toCourseEntityList(dto.getCourses())); //
        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setProfile(toProfileDTO(student.getProfile()));
        dto.setCourses(toCourseDTOList(student.getCourses()));
        return dto;
    }

    public Profile toProfileEntity(ProfileDTO dto) {
        if (dto == null) return null;

        Profile profile = new Profile();
        profile.setId(dto.getId());

        PersonaInfo personalInfo = new PersonaInfo();
        personalInfo.setFirstName(dto.getPersonaInfo().getFirstName());
        personalInfo.setLastName(dto.getPersonaInfo().getLastName());
        personalInfo.setDob(dto.getPersonaInfo().getDob());
        profile.setPersonaInfo(dto.getPersonaInfo());

        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress(dto.getContactInfo().getAddress());
        contactInfo.setPhoneNumber(dto.getContactInfo().getPhoneNumber());
        profile.setContactInfo(contactInfo);

        return profile;
    }

    public static ProfileDTO toProfileDTO(Profile profile) {
        if (profile == null) return null;

        ProfileDTO dto = new ProfileDTO();
        dto.setId(profile.getId());

        if (profile.getPersonaInfo()!= null) {
            PersonaInfo personalInfo = new PersonaInfo();
            personalInfo.setFirstName(profile.getPersonaInfo().getFirstName());
            personalInfo.setLastName(profile.getPersonaInfo().getLastName());
            personalInfo.setDob(profile.getPersonaInfo().getDob());
            dto.setPersonaInfo(personalInfo);
        }
        if (profile.getContactInfo()!= null) {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setAddress(profile.getContactInfo().getAddress());
            contactInfo.setPhoneNumber(profile.getContactInfo().getPhoneNumber());
            dto.setContactInfo(contactInfo);
        }
        return dto;
    }

    public List<Course> toCourseEntityList(List<CourseDTO> dtos) {
        if (dtos == null) return new ArrayList<>();

        List<Course> courses = new ArrayList<>();
        for (CourseDTO dto : dtos) {
            Course course = new Course();
            course.setId(dto.getId());
            course.setTitle(dto.getTitle());
            course.setDescription(dto.getDescription());
            courses.add(course);
        }
        return courses;
    }

    public List<CourseDTO> toCourseDTOList(List<Course> entities) {
        if (entities == null) return new ArrayList<>();

        List<CourseDTO> dtos = new ArrayList<>();
        for (Course entity : entities) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setDescription(entity.getDescription());
            dtos.add(dto);
        }
        return dtos;
    }
}
