package parkinglottest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parkinglotsystem.ParkingLotException;
import parkinglotsystem.ParkingLotSystem;

public class ParkingLotTest {

    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    public void givenVehicle_WhenParked_ShouldRetuenTrue() {
        boolean isParked = parkingLotSystem.parkVehicle(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehichle_WhenUnParked_ShouldReturnTrue() {
        parkingLotSystem.parkVehicle(vehicle);
        boolean isUnParked = false;
        try {
            isUnParked = parkingLotSystem.unParkVehicle(vehicle);
        } catch (ParkingLotException e) {
        }
        Assert.assertTrue(isUnParked);
    }

    @Test
    public void givenVehicleParkAndWhenUnParkedAnotherVehicle_ShouldThrowException() {
        parkingLotSystem.parkVehicle(vehicle);
        try {
            boolean isUnParked = parkingLotSystem.unParkVehicle(new Object());
            Assert.assertFalse(isUnParked);
        } catch (ParkingLotException e) {
            Assert.assertEquals("VEHICLE IS NOT AVAILABLE", e.getMessage());
        }
    }
}
