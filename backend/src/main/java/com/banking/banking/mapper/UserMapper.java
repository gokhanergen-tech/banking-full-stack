package com.banking.banking.mapper;

import com.banking.banking.dto.UserDto;
import com.banking.banking.model.User;
import com.banking.banking.request.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserFromRegisterRequest(RegisterRequest registerRequest);

    UserDto userToDto(User user);
}
