package com.mancio.JavaMicro;

import com.mancio.JavaMicro.dao.EmployeeDAO;
import com.mancio.JavaMicro.entities.Employees;
import com.mancio.JavaMicro.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@EnableCaching
public class CacheTests {

    @Autowired
    CacheManager cacheManager;

    @Mock
    EmployeeDAO employeeDAO;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    Employees emp;

    @Before
    public void setUp(){



        emp = new Employees();
        emp.setEmployee_id(0L);
        emp.setEmployee_name("foo");
        emp.setEmployee_last_name("cool");
        emp.setEmployee_address("ibhblo");
        emp.setEmployee_phone("+49786876");
        emp.setSalary(1500);
        emp.setCurrency("EUR");
        emp.setJob_position("expert");
        when(employeeServiceImpl.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(emp));
        when(employeeServiceImpl.save(any(Employees.class))).thenReturn(emp);
    }


    @Test
    public void testCacheIsPresent() {
        assertNotNull(cacheManager.getCache("employees"));
    }

    @Test
    public void testCacheIsWorking(){


        /* if cache is working properly after 2 query
           I should have only one database hit
         */
        Optional<Employees> employees_first_hit = employeeServiceImpl.findById(0L);
        assertEquals(employees_first_hit.get().getEmployee_name(),"foo");
        assertNotNull(cacheManager.getCache("employees"));
        Optional<Employees> employees_second_hit = employeeServiceImpl.findById(0L);
        assertEquals(employees_second_hit.get().getEmployee_name(),"foo");
        Mockito.verify(employeeDAO, times(1)).findById(anyLong());
    }

    @Test
    public void testSaveEmployee(){
        Employees employee = employeeServiceImpl.save(emp);
        assertNotNull(cacheManager.getCache("employees"));

    }
}
