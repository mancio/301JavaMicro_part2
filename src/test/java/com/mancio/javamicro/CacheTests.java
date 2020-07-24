package com.mancio.javamicro;

import com.mancio.javamicro.dao.EmployeeDAO;
import com.mancio.javamicro.entities.Employees;
import com.mancio.javamicro.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@EnableCaching
public class CacheTests {

    @Autowired
    CacheManager cacheManager;

    @Mock
    EmployeeDAO employeeDAO;

    @Autowired
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;




    public Employees buildEmployee(){
        Employees emp;
        emp = new Employees();
        emp.setEmployee_name("ijlili");
        emp.setEmployee_last_name("ijiji");
        emp.setEmployee_address("uhih");
        emp.setEmployee_phone("+5689876986");
        emp.setJob_position("iuyuyuyu");
        emp.setSalary(1400);
        emp.setCurrency("EUR");
        return emp;
    }

    public void clearCache(){
        cacheManager.getCache("employees").clear();
    }

    public int getCacheSize(){
        ConcurrentHashMap<?,?> cache = (ConcurrentHashMap<?, ?>) cacheManager.getCache("employees").getNativeCache();
        return cache.size();


    }

    public Employees getStoredEmployeeValue(Long id){
        Cache.ValueWrapper val = cacheManager.getCache("employees").get(id);
        Employees employee_cached = (Employees) val.get();
        return employee_cached;
    }

    @Test(expected = NullPointerException.class)
    public void testClearCache(){
        Optional<Employees> employees = employeeServiceImpl.findById(0L);
        assertNotNull(employees);
        clearCache();
        getStoredEmployeeValue(0L);
    }


    @Test
    public void testCacheIsPresent() {
        assertNotNull(cacheManager.getCache("employees"));
    }



    @Test
    public void testSaveEmployee(){
        clearCache();
        // save one employee cache has 1 entry
        Employees employee = employeeServiceImpl.save(buildEmployee());
        assertNotNull(employee);
        assertThat(getCacheSize()).isEqualTo(1);

        // save second employee cache has 2 entries
        Employees employee2 = employeeServiceImpl.save(buildEmployee());
        assertNotNull(employee2);
        assertThat(getCacheSize()).isEqualTo(2);


    }

    @Test
    public void testFindById(){
        clearCache();
        Optional<Employees> employees = employeeServiceImpl.findById(0L);
        assertNotNull(employees);
        employees = employeeServiceImpl.findById(1L);
        assertNotNull(employees);
        assertThat(getStoredEmployeeValue(0L).getEmployee_name()).isEqualTo("Bill");

    }

    @Test(expected = NullPointerException.class)
    /* Do not cache for findAll method because all the employees
       will be stored under a single key separated from the other keys
       with the rest of employees
     */
    public void testFindAllEmployees(){
        clearCache();
        Iterable<Employees> employees = employeeServiceImpl.findAll();
        assertNotNull(employees);
        assertNotNull(cacheManager.getCache("employees"));
        getStoredEmployeeValue(0L);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteById(){
        clearCache();
        Optional<Employees> employees = employeeServiceImpl.findById(0L);
        assertNotNull(employees);
        employeeServiceImpl.deleteById(0L);
        getStoredEmployeeValue(0L);
    }
}
