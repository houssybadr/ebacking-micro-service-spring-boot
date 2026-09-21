package org.sid.bank_account_service.entities;


import java.util.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountType;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
}