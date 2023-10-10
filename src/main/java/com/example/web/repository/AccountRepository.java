package com.example.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jdbc.repository.query.Query;

import com.example.web.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    
    @Query("SELECT * FROM account WHERE username = :username AND password = :password")
    Account findAccountByUsernameAndPassword(String username, String password);
    
}
