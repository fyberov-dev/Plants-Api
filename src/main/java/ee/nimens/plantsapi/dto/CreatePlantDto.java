package ee.nimens.plantsapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePlantDto(
        @NotNull
        @Size(min = 1, max = 100)
        @Pattern(regexp = "^[^\\x00]*$")
        String name,
        @NotNull
        @Min(0)
        @Max(1000000)
        int heightCm
) {}
