package com.alexrush1.requestserver.persistence.entity;

import com.alexrush1.requestserver.model.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    private String description;
}
