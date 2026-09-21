package org.sid.bank_account_service.controllers;

import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/bank-account")
public class BankAccountController {

    private BankAccountRepository repository;

    public BankAccountController(BankAccountRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<BankAccount> findAll(){
        return this.repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public BankAccount findById(@PathVariable String id){
        return this.repository.findById(id)
                .orElseThrow(()->new RuntimeException("Account Not Found"+id));
    }

    @PostMapping
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return this.repository.save(bankAccount);
    }

    @PutMapping(path="{id}")
    public BankAccount update(
            @RequestBody BankAccount bankAccount,
            @PathVariable String id
    ){
        BankAccount fetched=this.repository.findById(id)
                .orElseThrow(()->new RuntimeException("Account Not Found"+id));
        if(bankAccount.getBalance() != null) fetched.setBalance(bankAccount.getBalance());
        if(bankAccount.getType() != null) fetched.setType(bankAccount.getType());
        if(bankAccount.getCurrency() != null) fetched.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreatedAt() != null) fetched.setCreatedAt(bankAccount.getCreatedAt());
        return this.repository.save(fetched);
    }

    @DeleteMapping(path="{id}")
    public void deleteById(@PathVariable String id){
        this.deleteById(id);
    }
}
