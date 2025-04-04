package com.think.learn_springboot.service;

import com.think.learn_springboot.entity.Department;
import com.think.learn_springboot.error.DepartmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private  DepartmentService  departmentService;
    @BeforeEach
    void setUp(){

    }

    @Test
    public void fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Long id = 1253L;
        Department departmentFound
                = departmentService.fetchDepartmentById(departmentId);
        assertEquals(departmentFound.getDepartmentId() , id );
    }

    @Test
    void fetchDepartmentById() {
    }
}