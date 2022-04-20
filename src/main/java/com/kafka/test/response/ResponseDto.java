package com.kafka.test.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ResponseDto {

    private Integer code;

    private HttpStatus httpStatus;

    private String message;

    private Object result;

    public ResponseDto(Integer code, HttpStatus httpStatus, String message, Object result) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.result = result;
    }

    public ResponseDto(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.result = 1;
    }
}
