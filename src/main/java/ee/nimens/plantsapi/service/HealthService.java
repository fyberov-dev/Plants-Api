package ee.nimens.plantsapi.service;

import ee.nimens.plantsapi.db.DbHealthChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final DbHealthChecker dbHealthChecker;

    public boolean checkHealth() {
        return dbHealthChecker.checkHealth();
    }

}
