package org.sid.bank_account_service.service.Impl;

import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mapper.BankAccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.service.BankAccountService;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class BankAccountImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public BankAccountResponseDto createAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = bankAccountMapper.toEntity(bankAccountRequestDto);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new java.util.Date());
        return bankAccountMapper.toResponseDto(bankAccountRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponseDto updateAccount(BankAccountRequestDto bankAccountRequestDto, String id) {
        BankAccount bankAccount = findAccount(id);
        bankAccountMapper.updateEntity(bankAccountRequestDto, bankAccount);
        return bankAccountMapper.toResponseDto(bankAccountRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponseDto getAccountById(String id) {
        return bankAccountMapper.toResponseDto(findAccount(id));
    }

    @Override
    public void deleteAccount(String id) {
        if (!bankAccountRepository.existsById(id)) {
            throw new EntityNotFoundException("Account not found: " + id);
        }
        bankAccountRepository.deleteById(id);
    }

    @Override
    public List<BankAccountResponseDto> getAllAccounts() {
        return bankAccountMapper.toResponseDtos(bankAccountRepository.findAll());
    }

    private BankAccount findAccount(String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + id));
    }
}
