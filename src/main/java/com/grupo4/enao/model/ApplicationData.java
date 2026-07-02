package com.grupo4.enao.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationData {

    private String university;

    private Boolean internationalUniversity;

    private String country;

    private String otherUniversity;

    @Enumerated(EnumType.STRING)
    private SponsoringOrganization organization;

    private String bank;

    private String receiptCode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ApplicationStatus status = ApplicationStatus.PENDING;

    public enum SponsoringOrganization {
        MINSA,
        GOB_LOCAL,
        MIN_INTERIOR,
        ESSALUD
    }

    public enum ApplicationStatus {
        PENDING,
        VALIDATED,
        REJECTED
    }
}
