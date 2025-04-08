package com.think.learn_springboot.dto;

import com.think.learn_springboot.entity.Course;
import com.think.learn_springboot.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    private String name;
    private String email;
    private Profile profile;
    private List<Course> courses;
}
