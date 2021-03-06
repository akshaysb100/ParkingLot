package parkinglotsystem;

public class ParkingLotException extends Exception {
    public enum ExceptionType {
        PARKING_FULL, VEHICLE_NOT_FOUND
    }

    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
