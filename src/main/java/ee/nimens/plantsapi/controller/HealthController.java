package ee.nimens.plantsapi.controller;

import ee.nimens.plantsapi.dto.HealthStatus;
import ee.nimens.plantsapi.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public ResponseEntity<HealthStatus> checkHealth() {
        if (healthService.checkHealth()) {
            return ResponseEntity.status(HttpStatus.OK).body(new HealthStatus(HealthStatus.OK_STATUS));
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
