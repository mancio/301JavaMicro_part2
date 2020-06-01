package com.mancio.JavaMicro.dao;

import com.mancio.JavaMicro.entities.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employees,Long>{

}
