package org.sid.bank_account_service.controllers;

import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;
import org.sid.bank_account_service.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BankAccountResponseDto>> findAll() {
        return ResponseEntity.ok(this.bankAccountService.getAllAccounts());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BankAccountResponseDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.bankAccountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<BankAccountResponseDto> save(@RequestBody BankAccountRequestDto requestDto) {
        BankAccountResponseDto creatd= this.bankAccountService.createAccount(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatd);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BankAccountResponseDto> update(
            @RequestBody BankAccountRequestDto requestDto,
            @PathVariable String id
    ) {
        BankAccountResponseDto updated= this.bankAccountService.updateAccount(requestDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        this.bankAccountService.deleteAccount(id);
    }
}
