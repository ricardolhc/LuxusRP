import java.awt.Image;
import javax.swing.ImageIcon;

public class Passenger implements DrawableItem {

    private Location pickup;
    private Location destination;
    private Image image;
    
    public Passenger(Location pickup, Location destination) {
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }

        this.pickup = pickup;
        this.destination = destination;
        this.image = new ImageIcon(getClass().getResource("images/person.jpg")).getImage();
    }
    
    public String toString() { return "Passenger travelling from " + this.pickup + " to " + this.destination; }
    
    public Image getImage() { return this.image; }
    
    public Location getPickupLocation() { return this.pickup; }
    
    public Location getDestination() { return this.destination; }

    public Location getLocation() { return this.pickup; }
}
