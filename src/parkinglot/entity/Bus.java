package parkinglot.entity;

import parkinglot.strategy.FareStrategy;

public class Bus extends AbstractVehicle{

    public Bus(String numberPlate, FareStrategy fareStrategy) {
       super(numberPlate, fareStrategy);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.Bus;
    }


}

