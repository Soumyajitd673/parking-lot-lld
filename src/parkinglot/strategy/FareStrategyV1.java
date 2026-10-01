package parkinglot.strategy;

import parkinglot.entity.VehicleType;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class FareStrategyV1 implements FareStrategy{

    private final HashMap<VehicleType, Double> fareList;

    public FareStrategyV1(){
        this.fareList = new HashMap<>();
        fareList.put(VehicleType.Car, 2d);
        fareList.put(VehicleType.Bike, 1d);
        fareList.put(VehicleType.Bus, 5d);
    }

    @Override
    public double calculateFare(VehicleType type, LocalDateTime entryTime){

        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(entryTime, exitTime);

        long minutes = duration.toMinutes();
        long hours = (minutes + 59) / 60;

        double fare = hours * fareList.get(type);

        return fare;
    }
}
