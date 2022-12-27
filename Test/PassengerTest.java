package test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class PassengerTest {


    @org.junit.Test
    @DisplayName("Nada")
    public void getImage() {
        Passenger pas = new Passenger(new Location (1, 2) , new Location (1, 4));
        assertNotNull(pas.getImage());
    }

    @org.junit.Test
    public void getPickupLocationNull() {
        String expectedMessage = "Destination location";

        try{
            Passenger pass = new Passenger(new Location (1, 4), null);
        } catch (Exception e){
            assertTrue(e.getMessage().equals(expectedMessage));
        }
    }

    @org.junit.Test
    public void PassengerPickup() {
        assertThrows(NullPointerException.class, () -> {
            Passenger pass = new Passenger(null,new Location(1,1));
        });
    }

    @org.junit.Test
    public void PassengerDestination() {
        assertThrows(NullPointerException.class, () -> {
            Passenger pass = new Passenger(new Location(1,1),null);
        });
    }

    @org.junit.Test
    public void getPickupLocation() {
        Passenger pas = new Passenger(new Location (1, 4) , new Location (1, 2));
        assertNotNull(pas.getPickupLocation());
    }

    @org.junit.Test
    public void getDestinationNull() {
        String expectedMessage = "Pickup location";
        try{
            Passenger pass = new Passenger(null, new Location (1, 4));
        } catch (Exception e){

            assertTrue(e.getMessage().equals(expectedMessage));
        }

    }

    @org.junit.Test
    public void getDestination() {
        Passenger pas = new Passenger(new Location (1, 2), new Location (1, 4));
        assertNotNull(pas.getDestination());
    }
}
