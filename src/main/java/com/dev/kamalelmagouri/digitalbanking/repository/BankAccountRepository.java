package com.dev.kamalelmagouri.digitalbanking.repository;

import com.dev.kamalelmagouri.digitalbanking.entities.BankAccount;
import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

   // @RestResource(path = "/byType")
    //List<BankAccount> findByType(@Param("type")AccountType type);
}
