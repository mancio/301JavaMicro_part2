package com.mancio.javamicro.service;

import com.mancio.javamicro.entities.Employees;

import java.util.Optional;

public interface EmployeeService {
    Iterable<Employees> findAll();
    Optional<Employees> findById(Long id);
    Employees save(Employees emp);
    void deleteById(Long id);
}
