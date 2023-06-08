package com.alexrush1.requestserver.persistence.repository;

import com.alexrush1.requestserver.model.RequestStatus;
import com.alexrush1.requestserver.persistence.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, RequestStatus> {

    default Map<RequestStatus, StatusEntity> getAllStatusMap() {
        return findAll().stream()
                .collect(Collectors.toMap(StatusEntity::getStatus, status -> status));
    }
}
