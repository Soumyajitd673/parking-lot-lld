package parkinglot.entity;

import parkinglot.strategy.FareStrategy;


public class Car extends AbstractVehicle{

    public Car(String numberPlate, FareStrategy fareStrategy) {
       super(numberPlate, fareStrategy);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.Car;
    }
}
