package ch.conde.grafana_prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GrafanaPrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrafanaPrometheusApplication.class, args);
	}

}
