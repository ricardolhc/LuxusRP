import java.awt.Image;

import javax.swing.ImageIcon;

public class LuxCar extends Vehicle implements DrawableItem {

    private Passenger passenger;
    private Image emptyImage, passengerImage;
    
    public LuxCar(LuxCompany company, Location location) {
        super(company, location);
        this.emptyImage = new ImageIcon(getClass().getResource("images/luxCar.jpg")).getImage();
        this.passengerImage = new ImageIcon(getClass().getResource("images/luxCar+person.jpg")).getImage();
    }
 
    public void act() {
        Location target = getTargetLocation();

        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(this.passenger != null) {
                    notifyPassengerArrival(this.passenger);
                    offloadPassenger();
                } else {
                    notifyPickupArrival();
                }
            }
        }
    }

    public void pickup(Passenger passenger) {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    public void offloadPassenger() {
        this.passenger = null;
        clearTargetLocation();
    }
    
    public Image getImage() {
        if(this.passenger != null) {
            return this.passengerImage;
        } 
        return this.emptyImage;
    }

    public String toString() { return "luxCar at " + getLocation(); }

    public boolean isFree() { return getTargetLocation() == null && this.passenger == null; }
  
    public void setPickupLocation(Location location) { setTargetLocation(location); }
}
