package com.dev.kamalelmagouri.digitalbanking.dto;

import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {
    private double balance;
    private  String Currency;
    private AccountType type;
}
