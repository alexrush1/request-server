package com.alexrush1.requestserver.web;

import com.alexrush1.requestserver.api.Api;
import com.alexrush1.requestserver.api.ApiUri;
import com.alexrush1.requestserver.dto.request.CreateRequest;
import com.alexrush1.requestserver.dto.response.CreateRequestDtoResponse;
import com.alexrush1.requestserver.dto.response.RequestDto;
import com.alexrush1.requestserver.dto.response.RequestsListDto;
import com.alexrush1.requestserver.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController implements Api {

    private final RequestService requestService;

    @Override
    public CreateRequestDtoResponse createRequest(Principal principal, CreateRequest createRequest) {
        log.info("Получен запрос POST {}", ApiUri.REQUEST);
        var result = requestService.createRequest(null, createRequest);
        log.info("Выполнен запрос POST {}", ApiUri.REQUEST);
        return result;
    }

    @Override
    public RequestDto getRequest(Principal principal, UUID id) {
        log.info("Получен запрос GET {}", ApiUri.DETAIL_REQUEST);
        var result = requestService.getRequestById(null, id);
        log.info("Выполнен запрос GET {}", ApiUri.DETAIL_REQUEST);
        return result;
    }

    @Override
    public RequestsListDto getAllRequests(Principal principal, Integer pageSize, Integer pageOffset) {
        log.info("Получен запрос GET {}", ApiUri.REQUEST);
        var result = requestService.getAllRequests(null, pageSize, pageOffset);
        log.info("Выполнен запрос GET {}", ApiUri.REQUEST);
        return result;
    }
}
