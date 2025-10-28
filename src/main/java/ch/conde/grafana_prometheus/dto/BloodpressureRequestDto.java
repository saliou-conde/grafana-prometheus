package ch.conde.grafana_prometheus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BloodpressureRequestDto(
        @NotBlank String patientId,
        @NotNull Integer systole,
        @NotNull Integer diastole,
        @NotNull Integer heartRate,
        Integer map
        ) {
}
