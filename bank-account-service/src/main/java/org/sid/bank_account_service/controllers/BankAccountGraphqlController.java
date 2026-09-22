package org.sid.bank_account_service.controllers;

import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.service.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {

    private BankAccountService bankAccountService;

    public BankAccountGraphqlController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @QueryMapping
    public List<BankAccountResponseDto> accountList() {
        return this.bankAccountService.getAllAccounts();
    }

    @QueryMapping
    public BankAccountResponseDto bankAccountById(@Argument String id){
        return this.bankAccountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountResponseDto addBankAccount(@Argument BankAccountRequestDto bankAccount){
        return this.bankAccountService.createAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto updateBankAccount(@Argument BankAccountRequestDto bankAccount,@Argument String id){
        return this.bankAccountService.updateAccount(bankAccount,id);
    }

    @MutationMapping
    public Boolean deleteBankAcount(@Argument String id){
        this.bankAccountService.deleteAccount(id);
        return true;
    }
}
