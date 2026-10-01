package parkinglot.strategy;

import parkinglot.entity.Level;
import parkinglot.entity.Slot;
import parkinglot.entity.Vehicle;
import parkinglot.entity.VehicleType;
import java.util.ArrayList;
import java.util.Optional;

public interface EntryStrategy {

    Optional<Slot> findSlot(VehicleType type, ArrayList<Level> levels, Vehicle vehicle);

}
