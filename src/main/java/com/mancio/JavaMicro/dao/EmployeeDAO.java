package com.mancio.JavaMicro.dao;

import com.mancio.JavaMicro.entities.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EmployeeDAO extends CrudRepository<Employees,Long>{
    Iterable<Employees> findAll();
    Optional<Employees> findById(Long id);
    Employees save(Employees emp);
    void deleteById(Long id);
}
