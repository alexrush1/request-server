package com.alexrush1.requestserver.dto.response;

import java.util.UUID;

public record RequestDto(
        UUID id,
        String creationDate,
        String status,
        UUID clientId,
        String firstName,
        String lastName,
        String birthPlace,
        String birthday,
        String identificationCertificateFullNumber
) {
}
