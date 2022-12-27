import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class LuxCompany {
   
    private List<Vehicle> vehicles;
    private City city;
    private Map<Vehicle, Passenger> assignments;
    private Map<Vehicle, LinkedList<Passenger>> busAssignments;
    
    private static final int TOTAL_LUXCARS = 5;
    private static final int TOTAL_LUXBUS = 2;

    public LuxCompany(City city) {
        this.city = city;
        this.vehicles = new LinkedList<Vehicle>();
        this.assignments = new HashMap<Vehicle, Passenger>();
        this.busAssignments = new HashMap<Vehicle, LinkedList<Passenger>>();
        setupVehicles();
    }

    public boolean requestPickup(Passenger passenger) {
        Vehicle vehicle = scheduleCar();
        if(vehicle != null) {
            this.assignments.put(vehicle, passenger);
            vehicle.setPickupLocation(passenger.getLocation());
            return true;
        }
        return false;
    }

    
    public boolean requestBusPickup(LinkedList<Passenger> passengers) {
        Vehicle vehicle = scheduleBus();
        if(vehicle != null) {
            this.busAssignments.put(vehicle, passengers);
            for(Passenger pass : passengers) {
                Shuttle bus = (Shuttle) vehicle;
                bus.setTargetLocation(pass.getPickupLocation());
                bus.setPassengersWait(passengers);
            }
            return true;
        } 
        return false;
        
    }
    
    public void arrivedAtPickup(Vehicle vehicle) {
        if(vehicle.isCar()){
            Passenger passenger = this.assignments.remove(vehicle);
            if(passenger == null) {
                throw new MissingPassengerException(vehicle);
            }
            this.city.removeItem(passenger);
            vehicle.pickup(passenger);
        } else if(vehicle.isBus()) {
            Passenger target = null;
            LinkedList<Passenger> passengers = this.busAssignments.get(vehicle);
            for(Passenger passenger : passengers) {
                if(passenger == null) {
                    throw new MissingPassengerException(vehicle);
                }
                if(passenger.getLocation() == vehicle.getLocation()) {
                    target = passenger;
                }
            }
            if(target != null) {
                this.city.removeItem(target);
                vehicle.pickup(target);
            }
        }
    }

    private Vehicle scheduleCar(){
        for(Vehicle vehicle : vehicles) {
            if(vehicle.isCar() && vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    private Vehicle scheduleBus() {
        for(Vehicle vehicle : vehicles) {
            if(vehicle.isBus() && vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    public void setupVehicles() {
    	
    	int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();
        
        Random rand = new Random(12345);

        for(int i = 0; i < TOTAL_LUXCARS; i++){
            LuxCar luxcar = 
            		new LuxCar(this, new Location(rand.nextInt(cityWidth), 
            				rand.nextInt(cityHeight)));
            vehicles.add(luxcar);
            city.addItem(luxcar);
        }

        for(int i = 0; i < TOTAL_LUXBUS; i++){
            Shuttle bus = new Shuttle(this, 
            		new Location(rand.nextInt(cityWidth), 
            				rand.nextInt(cityHeight)));
            vehicles.add(bus);
            city.addItem(bus);
        }
    }

    public void arrivedAtDestination(Vehicle vehicle, Passenger passenger) {}

    public List<Vehicle> getVehicles() { return this.vehicles; }
}