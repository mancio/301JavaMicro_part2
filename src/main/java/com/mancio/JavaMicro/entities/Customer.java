package com.mancio.JavaMicro.entities;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBSCRIBER_ID", updatable = false, columnDefinition = "BIGINT(20)")
    private long subscriber_id;

    @Column(name = "REGISTERED_MOBILE", columnDefinition = "VARCHAR(20)")
    private String registered_mobile;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(20)")
    private String first_name;

    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(20)")
    private String last_name;

}
