package ee.nimens.plantsapi.mapper;

import ee.nimens.plantsapi.dto.PlantDto;
import ee.nimens.plantsapi.entity.Plant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public PlantDto toDto(Plant plant) {
        if (plant == null) {
            return null;
        }
        return PlantDto.builder()
                .id(plant.getId())
                .name(plant.getName())
                .heightCm(plant.getHeightCm())
                .build();
    }

    public List<PlantDto> toDtos(List<Plant> plants) {
        if (plants == null) {
            return List.of();
        }
        return plants.stream()
                .map(this::toDto)
                .toList();
    }

}
