package com.alexrush1.requestserver.exception;

import org.springframework.http.HttpStatus;

public class AnotherClientRequestException extends ServiceException {

    public AnotherClientRequestException() {
        super(HttpStatus.FORBIDDEN.value(), "Заявка принадлежит другому клиенту. Просмотр запрещен.");
    }
}
