package com.banking.banking.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> extends ApiResponse {
    private T data;

    public SuccessResponse(T data, String message, int status) {
        super(status, message);
        this.data = data;
    }
}
