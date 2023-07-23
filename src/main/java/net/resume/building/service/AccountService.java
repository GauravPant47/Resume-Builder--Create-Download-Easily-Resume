package net.resume.building.service;

import java.util.Optional;

import net.resume.building.model.Account;

public interface AccountService {
    Account save(Account account);

    Optional<Account> findOneByEmail(String Email);
}
