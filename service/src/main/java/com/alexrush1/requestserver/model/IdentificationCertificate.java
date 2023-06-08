package com.alexrush1.requestserver.model;

import lombok.Builder;

@Builder
public record IdentificationCertificate(
        String serial,
        String number
) {
}
