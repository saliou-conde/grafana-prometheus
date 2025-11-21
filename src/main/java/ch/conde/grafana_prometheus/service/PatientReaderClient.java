package ch.conde.grafana_prometheus.service;

import ch.conde.grafana_prometheus.dto.PatientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "bloodpressure-service",
        url = "${spring.config.bloodpressure-url}"
)
public interface PatientReaderClient {

    @GetMapping
    List<PatientResponseDto> getPatients();

    @GetMapping("/{id}")
    PatientResponseDto getPatient(@PathVariable("id") String id);
}
