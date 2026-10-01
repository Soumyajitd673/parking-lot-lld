package parkinglot.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Vehicle {

    Slot getSlot();

    double calculateFare();

    VehicleType getType();

    String getNumberPlate();

    LocalDateTime getEntryTime();

    public void setSlot(Slot slot);

}
