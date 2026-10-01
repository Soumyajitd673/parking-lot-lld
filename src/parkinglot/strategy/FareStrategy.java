package parkinglot.strategy;
import parkinglot.entity.VehicleType;
import java.time.*;
import java.util.HashMap;

public interface FareStrategy {

    double calculateFare(VehicleType type, LocalDateTime entryTime);
}
