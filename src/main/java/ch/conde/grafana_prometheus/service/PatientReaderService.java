package ch.conde.grafana_prometheus.service;

import ch.conde.grafana_prometheus.dto.PatientResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientReaderService {

    private final PatientReaderClient patientReaderClient;

    public List<PatientResponseDto> getPatients() {
        log.info("Fetching all patients from PatientReaderClient");
        List<PatientResponseDto> patients = patientReaderClient.getPatients();
        log.info("Fetched {} patients", patients.size());
        return patients;
    }
    @GetMapping("/{id}")
    public PatientResponseDto getPatient(@PathVariable("id") String id) {
        log.info("Fetching patient with id: {}", id);
        PatientResponseDto patient = patientReaderClient.getPatient(id);
        log.info("Fetched patient: {}", patient);
        return patient;
    }


}
