package com.alexrush1.requestserver.service;

import com.alexrush1.requestserver.dto.request.CreateRequest;
import com.alexrush1.requestserver.dto.response.CreateRequestDtoResponse;
import com.alexrush1.requestserver.dto.response.RequestDto;
import com.alexrush1.requestserver.dto.response.RequestsListDto;
import com.alexrush1.requestserver.exception.AnotherClientRequestException;
import com.alexrush1.requestserver.mapper.RequestMapper;
import com.alexrush1.requestserver.model.IdentificationCertificate;
import com.alexrush1.requestserver.model.RequestPayload;
import com.alexrush1.requestserver.model.RequestStatus;
import com.alexrush1.requestserver.persistence.entity.RequestEntity;
import com.alexrush1.requestserver.persistence.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final StatusService statusService;

    public RequestDto getRequestById(UUID clientId, UUID requestId) {

        var requestOptional = requestRepository.findById(requestId);

        if (requestOptional.isEmpty()) {
            return null;
        }

        var request = requestOptional.get();

        if (!request.getClientId().equals(clientId)) {
            throw new AnotherClientRequestException();
        }

        return requestMapper.toDto(request);
    }

    public RequestsListDto getAllRequests(UUID clientId, Integer pageSize, Integer pageOffset) {

        var requestList = requestRepository.findAll(PageRequest.of(pageOffset, pageSize))
                .stream()
                .filter(requestEntity -> requestEntity.getClientId().equals(clientId))
                .map(requestMapper::toDto)
                .toList();

        return RequestsListDto.builder()
                .pageSize(pageSize)
                .offset(pageOffset)
                .requests(requestList)
                .build();
    }

    public CreateRequestDtoResponse createRequest(UUID clientId, CreateRequest request) {
        return new CreateRequestDtoResponse(requestRepository.save(RequestEntity.builder()
                        .status(statusService.getStatusEntityByEnum(RequestStatus.NEW))
                        .clientId(clientId)
                        .payload(RequestPayload.builder()
                                .firstName(UUID.randomUUID().toString())
                                .lastName(UUID.randomUUID().toString())
                                .birthPlace(UUID.randomUUID().toString())
                                .birthday(LocalDate.now())
                                .identificationCertificate(IdentificationCertificate.builder()
                                        .number(UUID.randomUUID().toString())
                                        .serial(UUID.randomUUID().toString())
                                        .build())
                                .build())
                .build()
        ).getId());
    }
}
