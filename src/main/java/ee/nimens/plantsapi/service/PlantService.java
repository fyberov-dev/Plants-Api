package ee.nimens.plantsapi.service;

import ee.nimens.plantsapi.dto.CreatePlantDto;
import ee.nimens.plantsapi.dto.PlantDto;
import ee.nimens.plantsapi.entity.Plant;
import ee.nimens.plantsapi.exception.plant.PlantNotFoundException;
import ee.nimens.plantsapi.mapper.PlantMapper;
import ee.nimens.plantsapi.repository.PlantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;

    public List<PlantDto> listPlants() {
        return plantMapper.toDtos(plantRepository.findAll());
    }

    public List<PlantDto> listPlantsByName(String name) {
        return plantMapper.toDtos(plantRepository.findAllByName(name));
    }

    public PlantDto getPlant(int id) {
        return plantMapper.toDto(findPlantById(id));
    }

    public PlantDto createPlant(CreatePlantDto dto) {
        Plant createdPlant = plantRepository.save(Plant.builder()
                .name(dto.name())
                .heightCm(dto.heightCm())
                .build());
        return plantMapper.toDto(createdPlant);
    }

    public void deletePlant(int id) {
        Plant plant = findPlantById(id);
        plantRepository.delete(plant);
    }

    public Plant findPlantById(int id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException(id));
    }

}
