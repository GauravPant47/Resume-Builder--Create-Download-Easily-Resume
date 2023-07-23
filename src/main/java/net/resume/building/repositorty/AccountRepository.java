package net.resume.building.repositorty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findOneByEmailIgnoreCase(String email);
}