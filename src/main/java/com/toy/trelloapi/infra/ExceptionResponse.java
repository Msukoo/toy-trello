package com.toy.trelloapi.infra;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
