package parkinglot.strategy;

import parkinglot.entity.Level;
import parkinglot.entity.Slot;
import parkinglot.entity.Vehicle;
import parkinglot.entity.VehicleType;

import java.util.ArrayList;
import java.util.Optional;

public class EntryStrategyV1 implements EntryStrategy{

    @Override
    public Optional<Slot> findSlot(VehicleType type, ArrayList<Level> levels, Vehicle vehicle){

        for (Level level : levels){

            Slot[] slots = {};
            int count = 0;

            if (type == VehicleType.Car){
                slots = level.getCarSlots();
                count = level.getCarSlotCount();
            }
            else if (type == VehicleType.Bike) {
                slots = level.getBikeSlots();
                count = level.getBikeSlotCount();
            }
            else if (type == VehicleType.Bus){
                slots = level.getBusSlots();
                count = level.getBusSlotCount();
            }

            for (int i=0; i<count; i++){

                if (slots[i].isEmpty()){
                    slots[i].enterVehicle(vehicle);
                    return Optional.of(slots[i]);
                }
            }
        }

        return Optional.empty();
    }
}
