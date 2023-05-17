package com.dev.kamalelmagouri.digitalbanking.entities;

import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types= BankAccount.class, name ="P1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public double getBalance();

}
