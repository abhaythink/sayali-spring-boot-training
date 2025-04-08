package com.think.learn_springboot.dto;

import com.think.learn_springboot.entity.Course;
import com.think.learn_springboot.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private ProfileDTO profile;
    private List<CourseDTO> courses;
}
