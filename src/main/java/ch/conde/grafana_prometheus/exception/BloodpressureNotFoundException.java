package ch.conde.grafana_prometheus.exception;

public class BloodpressureNotFoundException extends RuntimeException {
    public BloodpressureNotFoundException(String message) {
        super(message);
    }
}
