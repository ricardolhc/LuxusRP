import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PassengerSource implements Actor {

    private City city;
    private LuxCompany company;
    private Random rand1;
    private Random rand2;
    private static final double CREATION_PROBABILITY = 0.06;
    
    //verifica se for nulo se não for nulo ele atribui e instancia uma valor randômico 
    public PassengerSource(City city, LuxCompany company) {
        if(city == null) {
            throw new NullPointerException("city");
        }
        if(company == null) {
            throw new NullPointerException("company");
        }
        this.city = city;
        this.company = company;
        this.rand1 = new Random(12345);
        this.rand2 = new Random();
    }
 
    
    //cria a probalilidade de passageiro
    public void act() {
        if(this.rand1.nextDouble() <= CREATION_PROBABILITY) {
            if(this.rand2.nextInt(2) == 0) {
                LinkedList<Passenger> passengers = createBusPassenger();
                if(company.requestBusPickup(passengers)) {
                    this.city.addItems(passengers);
                }
            } else {
                Passenger passenger = createCarPassenger();
                if(company.requestPickup(passenger)) {
                    this.city.addItem(passenger);
                }
            }
             
        }
    }

    //cria o passageiro em um determinado local do mapa
    private Passenger createCarPassenger() {
        Location pickupLocation = new Location(this.rand1.nextInt(this.city.getWidth()), this.rand1.nextInt(this.city.getHeight()));
        Location destination = getPassengerDestination(pickupLocation);

        return new Passenger(pickupLocation, destination);
    }

    private LinkedList<Passenger> createBusPassenger() {

        LinkedList<Passenger> passengers = new LinkedList<Passenger>();
        List<Location> pickupLocations = new LinkedList<Location>();
        List<Location> destinations = new LinkedList<Location>();
        Location destination = new Location(1, 1);

        int quantidadePassenger = this.rand2.nextInt(Shuttle.getMax() - Shuttle.getMin()) + Shuttle.getMin();

        for (int i = 0; i < quantidadePassenger; i++) {
            Location pickupLocation = new Location(this.rand1.nextInt(city.getWidth()), this.rand1.nextInt(city.getHeight()));
            pickupLocations.add(pickupLocation);

            if(i != 0) {
                if(this.rand2.nextInt(2) == 0) {
                    destinations.add(destination);
                } else {
                    destination = getPassengerDestination(pickupLocation);
                    destinations.add(destination);
                }
            } else {
                destination = getPassengerDestination(pickupLocation);
                destinations.add(destination);
            }
            passengers.add(new Passenger(pickupLocation, destination));
        }
        return passengers;
    }

    private Location getPassengerDestination(Location pickupLocation) {
        Location destination = new Location(1, 1);
        do {
            destination = new Location(this.rand1.nextInt(this.city.getWidth()), this.rand1.nextInt(this.city.getHeight()));
        } while(pickupLocation.equals(destination));
        return destination;
    }
}