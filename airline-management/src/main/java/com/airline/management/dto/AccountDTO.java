package com.airline.management.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountDTO {
    private Long id;
    private String accountNameEn;
    private String accountNameAr;
    private Long mainAccountId; // Reference to the main account
    private List<Long> subAccountIds; // List of IDs for sub-accounts
}
