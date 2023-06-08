package com.alexrush1.requestserver.mapper;

import com.alexrush1.requestserver.dto.response.RequestDto;
import com.alexrush1.requestserver.model.IdentificationCertificate;
import com.alexrush1.requestserver.persistence.entity.RequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface RequestMapper {

    @Mapping(source = "status.description", target = "status")
    @Mapping(source = "payload.firstName", target = "firstName")
    @Mapping(source = "payload.lastName", target = "lastName")
    @Mapping(source = "payload.birthPlace", target = "birthPlace")
    @Mapping(source = "payload.birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "payload.identificationCertificate", target = "identificationCertificateFullNumber", qualifiedByName = "formatIdenticalCertificateInfo")
    RequestDto toDto(RequestEntity requestEntity);

    @Named(value = "formatIdenticalCertificateInfo")
    default String formatIdenticalCertificateInfo(IdentificationCertificate identificationCertificate) {
        return String.format("Document info: #serial:%s #number:%s",
                identificationCertificate.serial(),
                identificationCertificate.number()
        );
    }
}
