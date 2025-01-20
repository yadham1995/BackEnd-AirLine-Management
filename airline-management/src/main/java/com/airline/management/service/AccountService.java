package com.airline.management.service;

import com.airline.management.dto.AccountDTO;
import com.airline.management.entity.Account;
import com.airline.management.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);

        // Handle mainAccount mapping
        if (accountDTO.getMainAccountId() != null) {
            Account mainAccount = accountRepository.findById(accountDTO.getMainAccountId())
                    .orElseThrow(() -> new RuntimeException("Main Account not found with id " + accountDTO.getMainAccountId()));
            account.setMainAccount(mainAccount);
        }

        account = accountRepository.save(account);
        return mapToDTO(account);
    }

    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id " + id));

        // Update basic fields
        existingAccount.setAccountNameEn(accountDTO.getAccountNameEn());
        existingAccount.setAccountNameAr(accountDTO.getAccountNameAr());

        // Handle parentCustomer mapping
        if (accountDTO.getMainAccountId() != null) {
            Account mainAccount = accountRepository.findById(accountDTO.getMainAccountId())
                    .orElseThrow(() -> new RuntimeException("Main Account not found with id " + accountDTO.getMainAccountId()));
            existingAccount.setMainAccount(mainAccount);
        } else {
            existingAccount.setMainAccount(null);
        }

        accountRepository.save(existingAccount);
        return mapToDTO(existingAccount);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id " + id));
        return mapToDTO(account);
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Parent and Sub-Accounts APIs
    public List<AccountDTO> getMainAccounts() {
        return accountRepository.findMainAccounts().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AccountDTO> getSubAccounts(Long mainAccountId) {
        return accountRepository.findSubAccountsByMainAccId(mainAccountId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to map Customer to CustomerDTO
    private AccountDTO mapToDTO(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        // Map parentCustomerId
        if (account.getMainAccount() != null) {
            accountDTO.setMainAccountId(account.getMainAccount().getId());
        }

        // Map subCustomerIds
        if (account.getSubAccounts() != null && !account.getSubAccounts().isEmpty()) {
            List<Long> subAccountIds = account.getSubAccounts().stream()
                    .map(Account::getId)
                    .collect(Collectors.toList());
            accountDTO.setSubAccountIds(subAccountIds);
        }

        return accountDTO;
    }
}
