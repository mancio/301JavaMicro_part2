package com.mancio.JavaMicro.dao;

import com.mancio.JavaMicro.entities.Employees;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDAO extends CrudRepository<Employees,Long>{
    @Cacheable("employees")
    Iterable<Employees> findAll();
    @Cacheable("employees")
    Optional<Employees> findById(Long id);
    @CachePut("employees")
    Employees save(Employees emp);
    @CacheEvict("employees")
    void deleteById(Long id);
}
