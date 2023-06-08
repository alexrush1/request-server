package com.alexrush1.requestserver.api;

import com.alexrush1.requestserver.dto.request.CreateRequest;
import com.alexrush1.requestserver.dto.response.CreateRequestDtoResponse;
import com.alexrush1.requestserver.dto.response.RequestDto;
import com.alexrush1.requestserver.dto.response.RequestsListDto;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

public interface Api {

    @PostMapping(ApiUri.REQUEST)
    CreateRequestDtoResponse createRequest(Principal principal, @RequestBody CreateRequest createRequest);

    @GetMapping(ApiUri.DETAIL_REQUEST)
    RequestDto getRequest(Principal principal, @PathVariable UUID id);

    @GetMapping(ApiUri.REQUEST)
    RequestsListDto getAllRequests(Principal principal, @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("pageOffset") Integer pageOffset);
}
