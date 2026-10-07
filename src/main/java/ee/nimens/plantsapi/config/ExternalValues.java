package ee.nimens.plantsapi.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.frontend")
public record ExternalValues(
        List<String> ips
) {}
