package com.alexrush1.requestserver.persistence.entity;

import com.alexrush1.requestserver.model.RequestPayload;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "request")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "status")
    private StatusEntity status;
    private UUID clientId;
    @JdbcTypeCode(SqlTypes.JSON)
    private RequestPayload payload;
}
