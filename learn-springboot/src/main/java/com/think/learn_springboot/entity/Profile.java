package com.think.learn_springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    private PersonaInfo personaInfo;

    @Embedded
    private ContactInfo contactInfo;

    @OneToOne(mappedBy = "profile")
    private Student student;
}
