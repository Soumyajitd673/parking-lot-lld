package parkinglot.controller;
import parkinglot.data.AllData;
import parkinglot.entity.Level;
import parkinglot.entity.Slot;
import parkinglot.entity.Vehicle;
import parkinglot.entity.VehicleType;
import parkinglot.factory.VehicleFactory;
import parkinglot.strategy.EntryStrategy;
import parkinglot.strategy.EntryStrategyV1;
import parkinglot.strategy.FareStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class SlotManager {

    private final ArrayList<Level> levels;
    private final HashSet<String> allNumberPlates;
    private int levelCount;
    private final EntryStrategy entryStrategy;
    private final VehicleFactory vehicleFactory;
    private final AllData allData;

    public SlotManager(EntryStrategy entryStrategy, VehicleFactory factory){

        this.vehicleFactory = factory;
        this.entryStrategy = entryStrategy;
        this.allData = new AllData();
        this.levels = new ArrayList<>();
        this.allNumberPlates = new HashSet<>();
        this.levelCount = 0;
    }

    public boolean addLevel(int totalSlot, int carSlotCount, int bikeSlotCount, int busSlotCount){
        Level level = new Level(levelCount, totalSlot, carSlotCount, bikeSlotCount, busSlotCount);
        levelCount ++;
        levels.add(level);

        allData.addSlots(level);

        return true;
    }

    public boolean enterVehicle(VehicleType type, String numberPlate){

        if (allNumberPlates.contains(numberPlate)){
            System.out.println("Vehicle already in parking.");
            return false;
        }

        Vehicle vehicle = vehicleFactory.get(type, numberPlate);
        Optional<Slot> slot = entryStrategy.findSlot(type, levels, vehicle);

        boolean isAvailable = slot.isPresent();

        if (isAvailable){
            vehicle.setSlot(slot.get());
            allData.addVehicle(numberPlate, vehicle);
            System.out.println("Vehicle Entered");
            System.out.println("Slot : " + slot.get().getSlotId());
        }
        else{
            System.out.println("No slots found.");
        }

        return isAvailable;
    }

    public double exitAndGetFare(String numberPlate){

        Vehicle vehicle = allData.getVehicle(numberPlate);
        if (vehicle == null) return -1;

        Slot slot = vehicle.getSlot();
        if (slot == null) return -1;

        slot.exitVehicle();
        allData.removeVehicle(numberPlate);

        double fare = vehicle.calculateFare();

        System.out.println("Vehicle Exited");
        System.out.println("Fare = "+fare+"$");

        return fare;
    }
}
