package parkinglot.entity;

import parkinglot.strategy.EntryStrategy;
import parkinglot.strategy.FareStrategy;

public class Bike extends AbstractVehicle{

    public Bike(String numberPlate, FareStrategy fareStrategy){
        super(numberPlate, fareStrategy);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.Bike;
    }

}
