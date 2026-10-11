package ee.nimens.plantsapi.dto;

public record HealthStatus(
        String status
) {

    public static final String OK_STATUS = "ok";
}
