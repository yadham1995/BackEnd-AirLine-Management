package com.airline.management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Table(name="Customer")
@Entity
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name_en")
    private String customerNameEn;

    @Column(name = "customer_name_ar")
    private String customerNameAr;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Customer parentCustomer;

    @OneToMany(mappedBy = "parentCustomer", cascade = CascadeType.ALL)
    private List<Customer> subCustomers;
}

