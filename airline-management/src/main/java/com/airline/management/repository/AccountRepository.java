package com.airline.management.repository;

import com.airline.management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT c FROM Account c WHERE c.mainAccount IS NULL")
    List<Account> findMainAccounts();

    @Query("SELECT c FROM Account c WHERE c.mainAccount.id = :mainAccountId")
    List<Account> findSubAccountsByMainAccId(@Param("mainAccountId") Long mainAccountId);
}
