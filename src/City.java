import java.util.LinkedList;
import java.util.List;   

public class City {

	private int width;
	private int height;
	
	private static final int DEFAULT_WIDTH = 16;
	private static final int DEFAULT_HEIGHT = 16;

    private List<Object> items;
	
    public City(int width, int height) {

        if(width < 1) {
            throw new IllegalArgumentException("Width must be positive: " + width);
        }
        if(height < 1) {
            throw new IllegalArgumentException("Height must be positive: " + height);
        }
        this.width = width;
        this.height = height;
        this.items = new LinkedList<Object>();
    }
    

    public City() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    

    public void addItems(LinkedList<Passenger> passengers) {
        for(Passenger pass : passengers) {
            if(this.items.contains(pass)) {
                throw new IllegalArgumentException(pass + " already recorded in the city.");
            }
            this.items.add(pass);
        }
    }

  
    public void addItem(Object item) {
        if(this.items.contains(item)) {
            throw new IllegalArgumentException(item + " already recorded in the city.");
        }
        this.items.add(item);
    }


    public void removeItem(Object item) {
        if(!this.items.remove(item)) {
            throw new IllegalArgumentException(item + " is not in the city.");
        }
    }

    public String toString() { return "City size " + this.width + " by " + this.height; }

    public int getWidth() { return this.width; }

    public int getHeight() { return this.height; }

    public List<Object> getItems() { return this.items; }
}
