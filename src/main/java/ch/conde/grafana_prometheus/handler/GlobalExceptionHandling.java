package ch.conde.grafana_prometheus.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ProblemDetail> handleFeignException(FeignException ex) {
        HttpStatus status = HttpStatus.resolve(ex.status());
        if (status == null) {
            status = INTERNAL_SERVER_ERROR;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> remoteBody = mapper.readValue(ex.contentUTF8(), Map.class);

            ProblemDetail problemDetail = ProblemDetail.forStatus(status);
            problemDetail.setTitle((String) remoteBody.getOrDefault("title", "Remote service error"));
            problemDetail.setDetail((String) remoteBody.getOrDefault("detail", ex.getMessage()));
            problemDetail.setProperty("instance", remoteBody.get("instance"));
            problemDetail.setProperty("timestamp", Instant.now());

            return new ResponseEntity<>(problemDetail, status);
        } catch (Exception parseError) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
            problemDetail.setTitle("Remote service error");
            problemDetail.setProperty("timestamp", Instant.now());
            return new ResponseEntity<>(problemDetail, status);
        }
    }

}
