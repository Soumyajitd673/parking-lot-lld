package parkinglot.entity;

public class Slot {

    private Vehicle vehicle = null;
    private final String slotId;

    public Slot(String slotId){
        this.slotId = slotId;
    }

    public boolean enterVehicle(Vehicle vehicle){

        if (! isEmpty()) return false;

        this.vehicle = vehicle;
        return true;
    }

    public boolean exitVehicle(){
        this.vehicle = null;
        return true;
    }

    public boolean isEmpty(){
        return vehicle == null;
    }

    public String getSlotId() {
        return slotId;
    }
}
