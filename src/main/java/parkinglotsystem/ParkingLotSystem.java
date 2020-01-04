package parkinglotsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    private int lotCapacity;
    private List<ParkingLot> parkingLots;

    public ParkingLotSystem(int lotCapacity) {
        this.lotCapacity = lotCapacity;
        this.parkingLots = new ArrayList<>();
    }

    public void addLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public boolean isLotAdded(ParkingLot parkingLot) {
        if (this.parkingLots.contains(parkingLot))
            return true;
        return false;
    }

    public void parkVehicle(Object vehicle, Enum type) throws ParkingLotException {
        ParkingLotStrategy parkingLotStrategy = FactoryObject.asadadf(type);
        ParkingLot lot = parkingLotStrategy.getParkingLot(this.parkingLots);
        lot.parkVehicle(vehicle, type);
    }

    public boolean isVehiclePark(Object vehicle) {
        for (int i = 0; i < this.parkingLots.size(); i++) {
            if (this.parkingLots.get(i).isVehiclePark(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Object vehicle) throws ParkingLotException {
        for (int parkingLot = 0; parkingLot < this.parkingLots.size(); parkingLot++) {
            if (this.parkingLots.get(parkingLot).unParkVehicle(vehicle)) {
                return true;
            }
        }
        throw new ParkingLotException("VEHICLE IS NOT AVAILABLE", ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND);
    }
}
