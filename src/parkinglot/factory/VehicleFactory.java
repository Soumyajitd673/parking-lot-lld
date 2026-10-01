package parkinglot.factory;

import parkinglot.entity.*;
import parkinglot.strategy.FareStrategy;

public class VehicleFactory {

    private final FareStrategy fareStrategy;

    public VehicleFactory(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public Vehicle get(VehicleType type, String numberplate){


        switch (type){
            case VehicleType.Car -> {
                return new Car(numberplate, fareStrategy);
            }
            case VehicleType.Bike -> {
                return new Bike(numberplate, fareStrategy);
            }
            case VehicleType.Bus -> {
                return new Bus(numberplate, fareStrategy);
            }

        }

        throw new IllegalArgumentException();
    }
}
