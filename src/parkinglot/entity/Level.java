package parkinglot.entity;

public class Level {

    private final int levelId;
    private final int totalSlot;
    private final int carSlotCount;
    private final int bikeSlotCount;
    private final int busSlotCount;

    private final Slot[] carSlots;
    private final Slot[] bikeSlots;
    private final Slot[] busSlots;

    public Level(int levelId, int totalSlot, int carSlotCount, int bikeSlotCount, int busSlotCount) {

        if (carSlotCount + bikeSlotCount + busSlotCount != totalSlot){
            throw new IllegalArgumentException();
        }
        this.levelId = levelId;
        this.totalSlot = totalSlot;
        this.carSlotCount = carSlotCount;
        this.bikeSlotCount = bikeSlotCount;
        this.busSlotCount = busSlotCount;

        this.carSlots = new CarSlot[carSlotCount];
        for(int i=0; i<carSlotCount; i++){
            carSlots[i] = new CarSlot("Car" +"_"+ levelId +"_"+ i);
        }

        this.bikeSlots = new BikeSlot[bikeSlotCount];
        for(int i=0; i<bikeSlotCount; i++){
            bikeSlots[i] = new BikeSlot("Bike" +"_"+ levelId +"_"+ i);
        }

        this.busSlots = new BusSlot[busSlotCount];
        for(int i=0; i<busSlotCount; i++){
            busSlots[i] = new BusSlot("Bus" +"_"+ levelId +"_"+ i);
        }
    }

    public int getCarSlotCount() {
        return carSlotCount;
    }

    public int getBikeSlotCount() {
        return bikeSlotCount;
    }

    public int getBusSlotCount() {
        return busSlotCount;
    }

    public Slot[] getCarSlots() {
        return carSlots;
    }

    public Slot[] getBikeSlots() {
        return bikeSlots;
    }

    public Slot[] getBusSlots() {
        return busSlots;
    }
}
