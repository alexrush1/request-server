package com.alexrush1.requestserver.dto.request;

import lombok.Builder;

@Builder
public record CreateRequest(
        String firstName,
        String lastName,
        String birthPlace,
        String birthday,
        String agreementId
) {
}
