package edu.home.repository;

import edu.home.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct au.account from Authoritie au where au.role.id in ('ADMIN', 'MANAGE')")
    List<Account> getAdministrators();
}