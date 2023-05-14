package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "First_Name",nullable = false)
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="email")
    private String email;

}
