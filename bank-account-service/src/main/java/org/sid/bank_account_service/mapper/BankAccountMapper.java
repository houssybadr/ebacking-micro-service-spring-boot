package org.sid.bank_account_service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.sid.bank_account_service.dto.BankAccountRequestDto;
import org.sid.bank_account_service.dto.BankAccountResponseDto;
import org.sid.bank_account_service.entities.BankAccount;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccount toEntity(BankAccountRequestDto requestDto);

    BankAccountResponseDto toResponseDto(BankAccount bankAccount);

    List<BankAccountResponseDto> toResponseDtos(List<BankAccount> bankAccounts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BankAccountRequestDto requestDto, @MappingTarget BankAccount bankAccount);
}
