package com.mancio.JavaMicro;

import com.mancio.JavaMicro.entities.Employees;
import com.mancio.JavaMicro.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DatabaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void dbPopulatedTest(){
        assertThat(employeeService).isNotNull();
    }

    @Test
    public void employeeStartSize(){
        // db initialized with 2 employees.
        Iterable<Employees> employees = employeeService.findAll();
        assertThat(employees).hasSize(2);
    }
}
