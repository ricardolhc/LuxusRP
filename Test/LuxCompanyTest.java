package test;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuxCompanyTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLuxCompany() {
		
		List<Vehicle> vehicles;
	    Map<Vehicle, Passenger> assignments;
	    Map<Vehicle, LinkedList<Passenger>> busAssignments;
		
		City ci = new City(35,35);
		City c2 = new City(38,38);
		Location l = new Location(3,4);
		Location l2 = new Location(6,8);
		
		
		vehicles = new LinkedList<Vehicle>();
		assignments = new HashMap<Vehicle, Passenger>();
<<<<<<< HEAD
		busAssignments = new HashMap<Vehicle, LinkedList<Passenger>>();
		
=======
>>>>>>> 9a38f27c4c0cb5a1e1b6bf03499105c6587f2fb5
		assertEquals(setupVehicles(), ci,l);

		
	}
	


private void assertEquals(short setupVehicles, City ci, Location l) {
		// TODO Auto-generated method stub
		
	}

private short setupVehicles() {
	
	return 0;
}

	@Test
	void testRequestPickup() {
		
LuxCompany l = new LuxCompany(new City());
		
		Passenger passenger = new Passenger(new Location(2,4), new Location(4,6));
		
		assertNotNull(l.requestPickup(passenger));

		
	}

	@Test
	void testRequestBusPickup() {
		
	}

	@Test
	void testArrivedAtPickup() {
		
	}

	@Test
	void testArrivedAtDestination() {
		
	}
	@Test
	void testGetVehicles() {
		
	}

	@Test
	void testObject() {
		
	}

	@Test
	void testGetClass() {
		
	}

	@Test
	void testHashCode() {
		
	}

	@Test
	void testEquals() {
		
	}

<<<<<<< HEAD
	@Test
	void testClone() {
		
	}

	@Test
	void testToString() {
		
	}

	@Test
	void testNotify() {
		
	}

	@Test
	void testNotifyAll() {
		
	}

	@Test
	void testWait() {
		
	}

	@Test
	void testWaitLong() {
		
	}

	@Test
	void testWaitLongInt() {
		
	}

	@Test
	void testFinalize() {
		
	}

=======
>>>>>>> 9a38f27c4c0cb5a1e1b6bf03499105c6587f2fb5
}
