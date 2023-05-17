package com.dev.kamalelmagouri.digitalbanking.services;

import com.dev.kamalelmagouri.digitalbanking.dto.BankAccountRequestDTO;
import com.dev.kamalelmagouri.digitalbanking.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount (BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);

}
