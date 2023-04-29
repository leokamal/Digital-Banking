package com.dev.kamalelmagouri.digitalbanking;

import com.dev.kamalelmagouri.digitalbanking.entities.Customer;
import com.dev.kamalelmagouri.digitalbanking.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DigitalBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankingApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return  args -> {
			for(int i=1; i<= 10; i++){
				Customer customer = Customer.builder()
						.firstName("First Name "+i)
						.lastName("Last Name "+i)
						.email("fn.ln."+i+"@gmail.com")
						.build();
				customerRepository.save(customer);
			}
		};
	}
}
