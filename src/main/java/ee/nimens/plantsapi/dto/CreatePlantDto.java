package ee.nimens.plantsapi.dto;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreatePlantDto(
        @Schema(requiredMode = REQUIRED,
                minLength = 1,
                maxLength = 100,
                pattern = "^[^\\u0000]*$")
        String name,
        @Schema(requiredMode = REQUIRED,
                minimum = "0",
                maximum = "1000000")
        int heightCm
) {}
