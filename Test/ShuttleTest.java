package test;

import org.junit.Test;

import javax.print.attribute.standard.Destination;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ShuttleTest {

    public List<Passenger> passengersWait;
    public List<Passenger> passengers;

    @Test
    public void testInit(){
        passengersWait = new LinkedList<Passenger>();
        assertTrue(passengersWait.isEmpty());
        assertTrue(passengersWait.size()==0);
    }

    @Test
    public void testAddInit(){
        passengersWait = new LinkedList<Passenger>();
        Passenger a = new Passenger(new Location(6,6), new Location(6,6));
        passengersWait.add(a);
        assertTrue(passengersWait.size() == 1);

        passengers = new LinkedList<Passenger>();
        Passenger b = new Passenger(new Location(6,6), new Location(6,6));
        passengers.add(b);
        assertTrue(passengers.size() == 1);
    }

    @Test
    public void testRListRemove(){
        passengersWait = new LinkedList<Passenger>();
        Passenger a = new Passenger(new Location(6,6), new Location(6,6));
        passengersWait.add(a);
        assertTrue(passengersWait.size() == 1);

        passengersWait.remove(a);
        assertTrue(passengersWait.size()==0);

        passengers = new LinkedList<Passenger>();
        Passenger b = new Passenger(new Location(6,6), new Location(6,6));
        passengers.add(b);
        assertTrue(passengers.size() == 1);

        passengers.remove(b);
        assertTrue(passengers.size()==0);
    }
    @Test
    public void listNotNull(){
        passengersWait = new LinkedList<Passenger>();
        passengersWait.add(0,new Passenger(new Location(7,9), new Location(6,7)));
        passengersWait.set(0,new Passenger(new Location(0,0), new Location(0,0)));
        assertNotNull(passengersWait);

    }

    @Test
        public void setPickupLocation() {
        passengersWait = new LinkedList<Passenger>();
        Passenger a = new Passenger(new Location(6,6), new Location(6,6));
        passengersWait.add(a);
        assertNotNull(passengersWait);
    }

    @Test
    public void pickup() {
        passengers = new LinkedList<Passenger>();
        passengersWait = new LinkedList<Passenger>();
        Passenger a = new Passenger(new Location(1,2), new Location(1,2));
        passengersWait.add(a);
        passengers.add(a);
        passengersWait.remove(a);
        assertNotNull(passengers);
        assertTrue(passengersWait.isEmpty());


    }

    @Test
    public void isFree() {
        passengers = new LinkedList<Passenger>();
        passengersWait = new LinkedList<Passenger>();

        assertTrue(passengers.isEmpty());
        assertTrue(passengersWait.isEmpty());

    }

    @Test
    public void offloadPassenger() {
        passengers = new LinkedList<Passenger>();
        Passenger a = new Passenger(new Location(6,6), new Location(6,6));
        passengers.add(a);
        assertTrue(passengers.size() == 1);

        passengers.remove(a);
        assertTrue(passengers.size()==0);
    }

}
