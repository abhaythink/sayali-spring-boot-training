package com.think.learn_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private UUID id;
    private String title;
    private String description;
}
