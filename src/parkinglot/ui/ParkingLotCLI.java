package parkinglot.ui;

import parkinglot.entity.VehicleType;

import java.util.Scanner;

public class ParkingLotCLI {

    private Scanner sc;

    public ParkingLotCLI(){
        sc = new Scanner(System.in);
    }

    public int homePage(){

        System.out.print("=== Parking Lot ===\n" +
                "\n" +
                "1. Add Level\n" +
                "2. Park Vehicle\n" +
                "3. Exit Vehicle\n" +
                "4. Exit\n" +
                "\n" +
                "Enter choice: ");

        int choice = sc.nextInt();
        System.out.println("");

        return choice;
    }

    public int[] addLevelPage(){

        int[] levelData = new int[4];

        System.out.println("Enter total slot count: ");
        levelData[0] = sc.nextInt();

        System.out.println("Enter car slot count: ");
        levelData[1] = sc.nextInt();

        System.out.println("Enter bike slot count: ");
        levelData[2] = sc.nextInt();

        System.out.println("Enter bus slot count: ");
        levelData[3] = sc.nextInt();

        return levelData;
    }

    public VehicleType parkVehiclePage(){

        System.out.println("Enter Vehicle Type");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Bus");
        System.out.print("\nEnter: ");

        int type = sc.nextInt();
        System.out.println("");

        switch (type){
            case 1 -> {
                return VehicleType.Car;
            }
            case 2 ->{
                return VehicleType.Bike;
            }
            case 3 ->{
                return VehicleType.Bus;
            }
        }

        System.out.println("Invalid Vehicle");
        return parkVehiclePage();
    }

    public String getNumberPlate(){

        System.out.print("Enter Number Plate: ");
        String numberPlate = sc.next();

        if (numberPlate.isBlank()){
            System.out.println("Invalid Number Plate");
            return getNumberPlate();
        }

        return numberPlate;
    }
}
