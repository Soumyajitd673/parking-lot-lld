package parkinglot.data;

import parkinglot.entity.Level;
import parkinglot.entity.Slot;
import parkinglot.entity.Vehicle;

import java.util.HashMap;

public class AllData {

    private final HashMap<String, Vehicle> allVehicles;
    private final HashMap<String, Slot> allSlots;

    public AllData() {
        this.allVehicles = new HashMap<>();
        this.allSlots = new HashMap<>();
    }

    public boolean addSlots(Level level){

        for (Slot slot : level.getCarSlots()){
            allSlots.put(slot.getSlotId(), slot);
        }

        for (Slot slot : level.getBikeSlots()){
            allSlots.put(slot.getSlotId(), slot);
        }

        for (Slot slot : level.getBusSlots()){
            allSlots.put(slot.getSlotId(), slot);
        }

        return true;
    }

    public boolean addVehicle(String numberPlate, Vehicle vehicle){
        allVehicles.put(numberPlate, vehicle);
        return true;
    }

    public Vehicle getVehicle(String numberplate){
        return allVehicles.get(numberplate);
    }

    public void removeVehicle(String numberPlate){
        allVehicles.remove(numberPlate);
    }

}
