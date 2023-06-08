package com.alexrush1.requestserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private Integer errorCode;
    private String errorDescription;
}
