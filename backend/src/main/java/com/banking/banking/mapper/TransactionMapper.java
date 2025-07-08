package com.banking.banking.mapper;

import com.banking.banking.dto.TransactionDto;
import com.banking.banking.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "from.number", target = "fromNumber")
    @Mapping(source = "to.number", target = "toNumber")
    TransactionDto transactionToDto(Transaction transaction);

    List<TransactionDto> transactionListToDtoList(List<Transaction> transactions);
}
