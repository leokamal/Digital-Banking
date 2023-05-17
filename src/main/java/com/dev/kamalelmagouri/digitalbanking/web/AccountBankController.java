package com.dev.kamalelmagouri.digitalbanking.web;

import com.dev.kamalelmagouri.digitalbanking.dto.BankAccountRequestDTO;
import com.dev.kamalelmagouri.digitalbanking.dto.BankAccountResponseDTO;
import com.dev.kamalelmagouri.digitalbanking.entities.BankAccount;
import com.dev.kamalelmagouri.digitalbanking.mappers.AccountMapper;
import com.dev.kamalelmagouri.digitalbanking.repository.BankAccountRepository;
import com.dev.kamalelmagouri.digitalbanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccountBankController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    private AccountBankController (BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper){
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public ResponseEntity bankAccount(@PathVariable String id){
        BankAccount bankAccount =   bankAccountRepository.findById(id).orElse(null);
            if(bankAccount== null){
                return  ResponseEntity.internalServerError().body(Map.of("message","this account doesn't existe"));
            }else {
                return ResponseEntity.ok().body(Map.of("bankAccount", bankAccount));
            }
    }

    @PostMapping("/bankAccount/")
    public BankAccountResponseDTO addAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount (bankAccountRequestDTO);

    }

     @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElse(null);
        if(account!=null){
            account.setBalance(bankAccount.getBalance());
            account.setCurrency(bankAccount.getCurrency());
            account.setType(bankAccount.getType());
            account.setCreatedAt(bankAccount.getCreatedAt());
            return bankAccountRepository.save(account);
        }
        return null;
     }

     @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
     }
}
