package com.think.learn_springboot.dto;

import com.think.learn_springboot.entity.ContactInfo;
import com.think.learn_springboot.entity.PersonaInfo;
import com.think.learn_springboot.entity.Student;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

    private UUID id;
    private PersonaInfo personaInfo;
    private ContactInfo contactInfo;
}
