package ee.nimens.plantsapi.repository;

import ee.nimens.plantsapi.entity.Plant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    List<Plant> findAllByName(String name);
}
