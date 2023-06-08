package com.alexrush1.requestserver.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RequestPayload(
        String firstName,
        String lastName,
        String birthPlace,
        LocalDate birthday,
        IdentificationCertificate identificationCertificate
){
}