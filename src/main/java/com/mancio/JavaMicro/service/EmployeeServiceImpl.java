package com.mancio.JavaMicro.service;

import com.mancio.JavaMicro.dao.EmployeeDAO;
import com.mancio.JavaMicro.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Employees> findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employees save(Employees emp) {
        return employeeDAO.save(emp);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }


}
