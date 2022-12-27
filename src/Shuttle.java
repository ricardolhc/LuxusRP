import java.util.List;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import java.awt.Image;
    
public class Shuttle extends Vehicle implements DrawableItem {

    private List<Passenger> passengersWait;
    private List<Passenger> passengers;
    private Image emptyImage;
    private Passenger targetPassenger;
    
    private static final int MIN_PASS = 4;
    private static final int MAX_PASS = 8;
    
    public Shuttle(LuxCompany company, Location location) {
        super(company, location);
        this.passengersWait = new LinkedList<Passenger>();
        this.passengers = new LinkedList<Passenger>();
        this.emptyImage = new ImageIcon(getClass().getResource("images/luxBus.jpg")).getImage();
    }

    public void act() {
        Location target = getTargetLocation();
        if(target != null) {
            //System.out.println("Quantidade passegeiros: " + passengers.size());
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(this.passengersWait.isEmpty()) {
                    notifyPassengerArrival(this.targetPassenger);
                    offloadPassenger(this.targetPassenger);
                } else {
                    notifyPickupArrival();
                }
            }
        }
    }
    
    //metodo para embarcar o passageiro
    public void pickup(Passenger passenger) {
        this.passengers.add(passenger);
        this.passengersWait.remove(passenger);
        chooseTargetLocation();
    }
    
    public boolean isFree() {
        return this.passengers.isEmpty() && this.passengersWait.isEmpty();
    }
    
    private void chooseTargetLocation() {
        if (!this.passengersWait.isEmpty()) {
            for(Passenger target : this.passengersWait) {
                this.targetPassenger = target;
                setTargetLocation(this.targetPassenger.getLocation());
            }
        } else if (!passengers.isEmpty()){
            for(Passenger target : passengers) {
                this.targetPassenger = target;
                setTargetLocation(this.targetPassenger.getDestination());
            }
        }
    }

    public void offloadPassenger(Passenger pass) {
        this.passengers.remove(pass);
        chooseTargetLocation();
    }

    public Image getImage() {
        if(this.passengers.isEmpty()) {
            return this.emptyImage;
        }
        return new ImageIcon(getClass().getResource("images/luxBus+person.jpg")).getImage();   
    }

    @Override
    public void setPickupLocation(Location location) {}

    @Override
    public void offloadPassenger() {}

    public void setPassengersWait(LinkedList<Passenger> pass) { this.passengersWait = pass; }

    public static int getMax() { return MAX_PASS; }

    public static int getMin() { return MIN_PASS; }

}
