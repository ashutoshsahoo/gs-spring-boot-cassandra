package com.ashu.practice.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;

@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = -6499260855940253962L;

    @PrimaryKey
    private int id;
    private String firstname;
    private String lastname;
    private int age;

}
