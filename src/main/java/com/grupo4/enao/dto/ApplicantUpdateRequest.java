package com.grupo4.enao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantUpdateRequest {

    @NotBlank(message = "La organización auspiciadora es obligatoria")
    private String organization;

    @NotBlank(message = "El banco es obligatorio")
    private String bank;

    @NotBlank(message = "El código de recibo es obligatorio")
    private String receiptCode;
}
