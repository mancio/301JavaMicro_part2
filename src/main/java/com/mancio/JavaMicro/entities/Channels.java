package com.mancio.JavaMicro.entities;

import javax.persistence.*;

@Entity
@Table(name = "CHANNELS")
public class Channels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBSCRIBER_ID", updatable = false, columnDefinition = "BIGINT(20)")
    private long subscriber_id;
}
