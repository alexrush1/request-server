package com.alexrush1.requestserver.persistence.repository;

import com.alexrush1.requestserver.persistence.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, UUID> {

    List<RequestEntity> findAllByClientId(UUID clientId);
}
