package com.think.learn_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDTO {
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
