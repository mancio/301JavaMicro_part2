package com.mancio.JavaMicro.entities;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID", updatable = false, columnDefinition = "BIGINT(20)")
    private long employee_id;

    


}
