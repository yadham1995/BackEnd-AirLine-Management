package com.airline.management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Table(name="Account")
@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name_en")
    private String accountNameEn;

    @Column(name = "account_name_ar")
    private String accountNameAr;

    @ManyToOne
    @JoinColumn(name = "main_account_id")
    private Account mainAccount;

    @OneToMany(mappedBy = "mainAccount", cascade = CascadeType.ALL)
    private List<Account> subAccounts;
}

