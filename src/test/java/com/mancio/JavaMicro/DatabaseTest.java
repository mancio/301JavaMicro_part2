package com.mancio.JavaMicro;

import com.mancio.JavaMicro.dao.EmployeeDAO;
import com.mancio.JavaMicro.entities.Employees;
import com.mancio.JavaMicro.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DatabaseTest {

    @Autowired
    CacheManager cacheManager;

    @Mock
    EmployeeDAO employeeDAO;

    @Autowired
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void dbPopulatedTest(){
        assertThat(employeeServiceImpl).isNotNull();
    }

    @Test
    public void employeeStartSize(){
        // db initialized with 2 employees.
        Iterable<Employees> employees = employeeServiceImpl.findAll();

        assertThat(employees).hasSize(2);
    }


}
