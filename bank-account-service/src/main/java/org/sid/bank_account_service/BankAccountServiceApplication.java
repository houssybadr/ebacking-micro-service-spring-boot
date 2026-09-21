package org.sid.bank_account_service;

import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.enums.AccountType;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository repository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAcc= BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.currency("MAD")
						.createdAt(new Date())
						.balance(Math.random()*9999999)
						.type(AccountType.CURRENT_ACCOUNT)
						.build();
				repository.save(bankAcc);

			}
		};
	}
}
