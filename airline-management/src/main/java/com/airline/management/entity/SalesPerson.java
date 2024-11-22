package com.airline.management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="SalesPerson")
@Entity
@Getter
@Setter
@ToString
public class SalesPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sales_person_code", nullable = false, unique = true)
    private String salesPersonCode;

    private String name;
}

