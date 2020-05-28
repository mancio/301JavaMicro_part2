package com.mancio.JavaMicro.entities;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID", updatable = false, columnDefinition = "BIGINT(20)")
    private long employee_id;

    @Column(name = "EMPLOYEE_NAME", columnDefinition = "VARCHAR(120)")
    private long employee_name;

    @Column(name = "EMPLOYEE_LAST_NAME", columnDefinition = "VARCHAR(120)")
    private long employee_last_name;

    @Column(name = "EMPLOYEE_ADDRESS", columnDefinition = "VARCHAR(120)")
    private long employee_address;

    @Column(name = "EMPLOYEE_PHONE", columnDefinition = "VARCHAR(120)")
    private long employee_phone;



}
