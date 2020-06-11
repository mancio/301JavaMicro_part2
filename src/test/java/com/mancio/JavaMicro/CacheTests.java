package com.mancio.JavaMicro;

import com.mancio.JavaMicro.dao.EmployeeDAO;
import com.mancio.JavaMicro.entities.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CacheTests {

    

    @Autowired
    CacheManager cacheManager;
    @Autowired
    EmployeeDAO repomock;

    EmployeeDAO mock = Mockito.mock(EmployeeDAO.class);

    @Test
    public void testCacheAll() {

        // it say "cached" if it is already in the cache
        //doAnswer(invocation -> "cached").when(repo).findAll();

        // we invoke findAll twice.
        Object allEmp1 = mock.findAll();
        assertNotNull(allEmp1);
        Object allEmp2 = repomock.findAll();
        assertNotNull(allEmp2);

        // verify the mock repo is called only ones
        //verify(repomock, times(2)).findAll();
        assertNotNull(cacheManager.getCache("employees"));


    }

    @Test
    public void testCacheById(){
        //TestRepo testRepo = Mockito.mock(TestRepo.class);

        Optional<Employees> Emp1 = repomock.findById((long)0);
        assertNotNull(Emp1);
        assertNotNull(cacheManager.getCache("employees"));
    }
}
