package com.alexrush1.requestserver.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RequestsListDto(
        Integer pageSize,
        Integer offset,
        List<RequestDto> requests
) {
}
