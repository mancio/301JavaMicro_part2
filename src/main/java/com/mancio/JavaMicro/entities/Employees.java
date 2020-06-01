package com.mancio.JavaMicro.entities;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false, columnDefinition = "BIGINT(20)")
    private long employee_id;

    @Column(name = "EMPLOYEE_NAME", columnDefinition = "VARCHAR(120)")
    private String employee_name;

    @Column(name = "EMPLOYEE_LAST_NAME", columnDefinition = "VARCHAR(120)")
    private String employee_last_name;

    @Column(name = "EMPLOYEE_ADDRESS", columnDefinition = "VARCHAR(120)")
    private String employee_address;

    @Column(name = "EMPLOYEE_PHONE", columnDefinition = "VARCHAR(120)")
    private String employee_phone;

    @Column(name = "JOB_POSITION", columnDefinition = "VARCHAR(120)")
    private String job_position;

    @Column(name = "SALARY", columnDefinition = "INT(20)")
    private int salary;

    @Column(name = "CURRENCY", columnDefinition = "VARCHAR(5)")
    private String currency;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public String getEmployee_address(String s) {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
