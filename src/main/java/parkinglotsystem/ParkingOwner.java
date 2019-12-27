package parkinglotsystem;

public class ParkingOwner implements ParkingLotObserver {
    private boolean parkingCapacity;

    @Override
    public void parkingFull() {
        this.parkingCapacity = true;
    }

    @Override
    public boolean isParkingFull() {
        return this.parkingCapacity;
    }
}
