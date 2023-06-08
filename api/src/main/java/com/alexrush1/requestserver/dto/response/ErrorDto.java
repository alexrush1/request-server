package com.alexrush1.requestserver.dto.response;

public record ErrorDto(
        Integer errorCode,
        String errorDescription
) {
}
