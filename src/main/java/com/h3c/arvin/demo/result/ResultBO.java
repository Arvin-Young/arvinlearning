package com.h3c.arvin.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBO<T> {
    private int code;
    private String message;
    private T data;

    public ResultBO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
