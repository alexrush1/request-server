package com.alexrush1.requestserver.web;

import com.alexrush1.requestserver.dto.response.ErrorDto;
import com.alexrush1.requestserver.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ServiceException.class)
    public ErrorDto catchServiceException(ServiceException serviceException) {
        log.error("Обработана ошибка: {}", serviceException.getMessage());
        return new ErrorDto(serviceException.getErrorCode(), serviceException.getErrorDescription());
    }
}
