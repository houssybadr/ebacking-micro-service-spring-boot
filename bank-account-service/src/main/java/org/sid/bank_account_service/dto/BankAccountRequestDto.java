package org.sid.bank_account_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountType;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDto {
    private Double balance;
    private String currency;
    private AccountType type;
}