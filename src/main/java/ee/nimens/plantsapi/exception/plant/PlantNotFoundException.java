package ee.nimens.plantsapi.exception.plant;

import java.io.Serial;

public class PlantNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1000L;

    public PlantNotFoundException(int plantId) {
        super(String.format("Plant with id %d was not found", plantId));
    }

}
