package ee.nimens.plantsapi.controller;

import ee.nimens.plantsapi.dto.CreatePlantDto;
import ee.nimens.plantsapi.dto.PlantDto;
import ee.nimens.plantsapi.service.PlantService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plants")
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping
    public ResponseEntity<List<PlantDto>> listPlants(
            @RequestParam(name = "name", required = false) Optional<String> name
    ) {
        if (name.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(plantService.listPlantsByName(name.get()));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(plantService.listPlants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDto> getPlant(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(plantService.getPlant(id));
    }

    @PostMapping
    public ResponseEntity<PlantDto> createPlant(@Valid @RequestBody CreatePlantDto createPlantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plantService.createPlant(createPlantDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        plantService.deletePlant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
