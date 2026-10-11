package ee.nimens.plantsapi.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DbHealthChecker {

    private final DataSource dataSource;

    public boolean checkHealth() {
        try (Connection connection = dataSource.getConnection()) {
            return connection.isValid(2);
        } catch (SQLException ex) {
            log.debug("Database healthcheck failed", ex);
            return false;

        }
    }
}
