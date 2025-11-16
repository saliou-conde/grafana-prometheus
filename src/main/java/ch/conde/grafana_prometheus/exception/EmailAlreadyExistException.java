package ch.conde.grafana_prometheus.exception;

public class EmailAlreadyExistException extends RuntimeException {
  public EmailAlreadyExistException(String message) {
    super(message);
  }

}
