package com.dev.kamalelmagouri.digitalbanking.mappers;

import com.dev.kamalelmagouri.digitalbanking.dto.BankAccountResponseDTO;
import com.dev.kamalelmagouri.digitalbanking.entities.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
