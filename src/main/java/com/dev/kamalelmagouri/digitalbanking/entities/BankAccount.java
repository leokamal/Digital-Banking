package com.dev.kamalelmagouri.digitalbanking.entities;

import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private String currency;
    private Date CreatedAt;
    private AccountType type;
    @ManyToOne()
    private Customer customer;
}
