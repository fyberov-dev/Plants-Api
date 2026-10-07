package ee.nimens.plantsapi.dto;

import lombok.Builder;

@Builder
public record PlantDto(
        int id,
        String name,
        int heightCm
) {}
