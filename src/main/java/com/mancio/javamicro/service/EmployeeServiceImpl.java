package com.mancio.javamicro.service;

import com.mancio.javamicro.dao.EmployeeDAO;
import com.mancio.javamicro.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override

    public Iterable<Employees> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Cacheable(value = "employees", key = "#id")
    public Optional<Employees> findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override

    @CachePut(value = "employees", key = "#emp.employee_id")
    public Employees save(Employees emp) {
        return employeeDAO.save(emp);
    }

    @Override
    @CacheEvict(value = "employees", key = "#id")
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }


}
