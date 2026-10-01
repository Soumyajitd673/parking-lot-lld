package parkinglot.entity;

import parkinglot.strategy.FareStrategy;
import java.time.LocalDateTime;

public abstract class AbstractVehicle implements Vehicle{

    private final String numberPlate;
    private Slot slot;
    private final LocalDateTime entryTime;
    private final FareStrategy fareStrategy;

    public AbstractVehicle(String numberPlate, FareStrategy fareStrategy) {
        this.numberPlate = numberPlate;
        this.entryTime = LocalDateTime.now();
        this.fareStrategy = fareStrategy;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public Slot getSlot() {
        return slot;
    }

    @Override
    public void setSlot(Slot slot) {
        this.slot = slot;
    }


    @Override
    public double calculateFare() {
        VehicleType type = this.getType();
        return fareStrategy.calculateFare(type, entryTime);
    }
}
