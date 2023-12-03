package com.crud.angularAndSpringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @GeneratedValue
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
}
