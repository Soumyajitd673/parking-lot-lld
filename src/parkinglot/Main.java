package parkinglot;


import parkinglot.controller.SlotManager;
import parkinglot.entity.VehicleType;
import parkinglot.factory.VehicleFactory;
import parkinglot.strategy.EntryStrategyV1;
import parkinglot.strategy.FareStrategyV1;
import parkinglot.ui.ParkingLotCLI;

public class Main {

    public static void main(String[] args) {

        run();
    }

    public static void run(){
        ParkingLotCLI ui = new ParkingLotCLI();
        VehicleFactory factory = new VehicleFactory(new FareStrategyV1());
        SlotManager slotManager = new SlotManager(new EntryStrategyV1(), factory);

        while (true) {

            int choice = ui.homePage();

            switch (choice) {
                    case 1 -> {
                        int[] levelData = ui.addLevelPage();
                        slotManager.addLevel(levelData[0], levelData[1], levelData[2], levelData[3]);
                        break;
                    }
                    case 2 -> {
                        VehicleType type = ui.parkVehiclePage();
                        String numberPlate = ui.getNumberPlate();

                        slotManager.enterVehicle(type, numberPlate);
                        break;
                    }
                    case 3 -> {

                        String numberPlate = ui.getNumberPlate();
                        slotManager.exitAndGetFare(numberPlate);
                        break;
                    }
                    case 4 -> {
                        System.exit(0);
                        break;
                    }
                    default -> {
                        System.out.println("Invalid choice.");
                    }

                }

            }
    }
}
