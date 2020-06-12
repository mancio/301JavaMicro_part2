package com.mancio.JavaMicro.controller;

import com.mancio.JavaMicro.customExceptions.CustomNotFound;
import com.mancio.JavaMicro.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mancio.JavaMicro.service.EmployeeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employees> getAllEmployees(){
        return (List<Employees>) employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employees>> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Optional<Employees> empl = employeeService.findById(employeeId);
        if(!empl.isPresent()){
            throw new CustomNotFound(employeeId);
        }
        else return ResponseEntity.ok().body(empl);





    }

    @PostMapping("/employees")
    public Employees createEmployee(@Valid @RequestBody Employees employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map< String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        try{
            employeeService.deleteById(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomNotFound(employeeId);
        }
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
