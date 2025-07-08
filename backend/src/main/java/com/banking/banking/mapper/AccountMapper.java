package com.banking.banking.mapper;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "balance", source = "balance", qualifiedByName = "formatBalance")
    AccountDto accountToDto(Account account);

    @Named("formatBalance")
    default BigDecimal formatBalance(BigDecimal balance) {
        if (balance == null) {
            return null;
        }
        return balance.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    List<AccountDto> accountListToDtoList(List<Account> accounts);
}
