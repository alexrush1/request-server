package com.alexrush1.requestserver.service;

import com.alexrush1.requestserver.model.RequestStatus;
import com.alexrush1.requestserver.persistence.entity.StatusEntity;
import com.alexrush1.requestserver.persistence.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;
    private Map<RequestStatus, StatusEntity> statusMap;

    public StatusEntity getStatusEntityByEnum(RequestStatus requestStatus) {
        initIfNull();
        return statusMap.get(requestStatus);
    }

    private void initIfNull() {
        if (Objects.isNull(statusMap)) {
            synchronized (this) {
                if (Objects.isNull(statusMap)) {
                    statusMap = statusRepository.getAllStatusMap();
                }
            }
        }
    }

}
