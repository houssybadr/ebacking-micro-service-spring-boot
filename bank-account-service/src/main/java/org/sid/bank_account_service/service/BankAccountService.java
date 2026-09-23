package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;

import java.util.List;

public interface BankAccountService {
    BankAccountResponseDto createAccount(BankAccountRequestDto bankAccountRequestDto);
    BankAccountResponseDto updateAccount(BankAccountRequestDto bankAccountRequestDto, String id);
    BankAccountResponseDto getAccountById(String id);
    List<BankAccountResponseDto> getAllAccounts();
    Boolean exists(String id);
    void deleteAccount(String id);

}
