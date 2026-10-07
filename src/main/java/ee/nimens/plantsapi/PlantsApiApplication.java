package ee.nimens.plantsapi;

import ee.nimens.plantsapi.config.ExternalValues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ExternalValues.class)
public class PlantsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantsApiApplication.class, args);
    }

}
