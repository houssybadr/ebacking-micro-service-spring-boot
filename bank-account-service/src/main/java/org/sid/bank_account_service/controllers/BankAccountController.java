package org.sid.bank_account_service.controllers;

import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;
import org.sid.bank_account_service.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bank-account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public List<BankAccountResponseDto> findAll() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    public BankAccountResponseDto findById(@PathVariable String id) {

        return this.bankAccountService.getAccountById(id);
    }

    @PostMapping
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto requestDto) {
        return this.bankAccountService.createAccount(requestDto);
    }

    @PutMapping(path = "/{id}")
    public BankAccountResponseDto update(
            @RequestBody BankAccountRequestDto requestDto,
            @PathVariable String id
    ) {
        return this.bankAccountService.updateAccount(requestDto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable String id) {
        this.bankAccountService.deleteAccount(id);
    }
}
