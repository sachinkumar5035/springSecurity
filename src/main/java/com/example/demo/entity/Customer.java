package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="CUSTOMER_INFO")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String department;
    private String salary;

}
