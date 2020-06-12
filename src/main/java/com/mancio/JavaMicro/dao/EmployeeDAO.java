package com.mancio.JavaMicro.dao;

import com.mancio.JavaMicro.entities.Employees;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EmployeeDAO extends CrudRepository<Employees,Long>{
    @Cacheable("employees")
    Iterable<Employees> findAll();
    @Cacheable("employees")
    Optional<Employees> findById(Long id);
    @Cacheable("employees")
    Employees save(Employees emp);
    @CacheEvict("employees")
    void deleteById(Long id);
}
