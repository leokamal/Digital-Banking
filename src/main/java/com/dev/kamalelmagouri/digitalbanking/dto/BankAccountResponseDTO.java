package com.dev.kamalelmagouri.digitalbanking.dto;

import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;
}
