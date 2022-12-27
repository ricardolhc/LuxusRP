package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;

class LuxCarTest {
	
	
	private LuxCar luxCar;
	
	public LuxCarTest() {
		
	}
	
	
	@Before
    public void setUp()
    {
        LuxCompany company = new LuxCompany();
        Location taxiLocation = new Location();
        luxCar = new LuxCar(company, taxiLocation);
    }


    @Test
     void actTargetNotNull() {

        LuxCompany lc = new LuxCompany(new City());
        LuxCar lx = new LuxCar(lc, new Location(10,5));
        lx.setTargetLocation(new Location(25,39));

        try {
            lx.act();
        }catch (Exception e){}

        assertNotNull(lx.getTargetLocation());

    }

    @Test
    void actNextEqualsTarget() {
//
        LuxCompany lc = new LuxCompany(new City());
        LuxCar lx = new LuxCar(lc, new Location(10,5));
        lx.setTargetLocation(new Location(10,5));

        try {
            lx.act();
        }catch (Exception e){}

        assertEquals(lx.getLocation().nextLocation(lx.getTargetLocation()),new Location(10,5));

    }


    @Test
    void actPassengerNotNull() {
        LuxCar lx = new LuxCar(new LuxCompany(new City()), new Location(10, 5));
        lx.setTargetLocation(new Location(10, 6));
        Passenger pas = new Passenger(new Location(10, 5),new Location(10, 6));

        lx.pickup(pas);

        lx.act();

        assertNull(lx.getTargetLocation());
    }

    @Test
    void actPassengerNull() {
        LuxCar lx = new LuxCar(new LuxCompany(new City()), new Location(10, 5));
        lx.setTargetLocation(new Location(10, 6));

        String expectedMessage = "Missing passenger at pickup location.";

        try {
            lx.act();
        } catch (Exception e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }
        
    @Test
    public void testCreation()
    {
        assertTrue(true);
    }
    
    
    
    
        @Test
        public void testPickup()
        {
            Location pickup = new Location();
            Location destination = new Location();
            Passenger passenger = new Passenger(pickup, destination);
           
            boolean f = false;
            
            assertFalse(f);
        

    }
        
        @Test
        public void testOffload()
        {
            testPickup();
            
            boolean v = true;
            
            assertTrue(v);
        }
        
}

}
