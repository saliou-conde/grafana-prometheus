package ch.conde.grafana_prometheus.controller;

import ch.conde.grafana_prometheus.dto.PatientResponseDto;
import ch.conde.grafana_prometheus.service.PatientReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientReaderController {

    private final PatientReaderService service;

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        return ResponseEntity.ok(service.getPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatient(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getPatient(id));
    }

}
