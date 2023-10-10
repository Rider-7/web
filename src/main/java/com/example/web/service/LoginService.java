package com.example.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.example.web.repository.AccountRepository;
import com.example.web.model.Account;

@Service
@RequestScope
public class LoginService {
    private AccountRepository accountRepository;
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginService(AccountRepository accountRepository, LoggedUserManagementService loggedUserManagementService) {
        this.accountRepository = accountRepository;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean validateLogin(String username, String password) {
        boolean loginResult = false;
        Account account = accountRepository.findAccountByUsernameAndPassword(username, password);
        if (account != null) {        
            loggedUserManagementService.setUsername(account.username());
            loggedUserManagementService.setType(account.type());
            loginResult = true;
        }
        return loginResult;
    }
}


