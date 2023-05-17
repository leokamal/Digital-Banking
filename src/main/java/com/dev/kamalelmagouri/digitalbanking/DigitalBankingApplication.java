package com.dev.kamalelmagouri.digitalbanking;

import com.dev.kamalelmagouri.digitalbanking.entities.BankAccount;
import com.dev.kamalelmagouri.digitalbanking.entities.Customer;
import com.dev.kamalelmagouri.digitalbanking.enums.AccountType;
import com.dev.kamalelmagouri.digitalbanking.repository.BankAccountRepository;
import com.dev.kamalelmagouri.digitalbanking.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankingApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository,CustomerRepository customerRepository){

		return  args -> {
			Stream.of("Kamal","Hicham","Ibtissam").forEach(c-> {
				Customer customer = Customer.builder().firstName(c).email(c+"@gmail.com").build();
				customerRepository.save(customer);
			});
		customerRepository.findAll().forEach(customer -> {
			for (int i =1; i<=3;i++){
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type( (i%2==0)? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
						.balance(2000*Math.random()*10000)
						.currency("MAD")
						.createdAt(new Date())
						.customer(customer)
						.build();
				bankAccountRepository.save(bankAccount);


			}
		});
		};
	}
}
