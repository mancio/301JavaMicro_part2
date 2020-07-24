package com.mancio.javamicro.kafka;

import com.google.gson.Gson;
import com.mancio.javamicro.entities.Employees;
import com.mancio.javamicro.entities.EmployeesRating;
import com.mancio.javamicro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class KafkaConsumerService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Gson gson;

    @KafkaListener(topics = "rating-topic", groupId = "ratings")
    public void consume(@RequestBody String emp){
        System.out.println("Consumed Message :"+ emp);
        EmployeesRating employeesRating = gson.fromJson(emp, EmployeesRating.class);
        System.out.println("find id = " + employeesRating.getId());
        Optional<Employees> newOptionalEmployee = employeeService.findById(employeesRating.getId());
        if (!newOptionalEmployee.isPresent()){
            System.out.println("Error: employee not present");
        }else {
            Employees newEmployee = newOptionalEmployee.get();
            newEmployee.setEmployee_id(employeesRating.getId());
            newEmployee.setRating(employeesRating.getRating());
            System.out.println(newEmployee.toString());
            employeeService.save(newEmployee);
        }

    }
}