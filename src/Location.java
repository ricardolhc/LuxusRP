public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        if(x < 0) {
            throw new IllegalArgumentException("Negative x-coordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException("Negative y-coordinate: " + y);
        }
        this.x = x;
        this.y = y;
    }
    

    public Location nextLocation(Location destination) {
        int destX = destination.getX();
        int destY = destination.getY();
        int offsetX = this.x < destX ? 1 : this.x > destX ? -1 : 0;
        int offsetY = this.y < destY ? 1 : this.y > destY ? -1 : 0;
        if(offsetX != 0 || offsetY != 0) {
            return new Location(this.x + offsetX, this.y + offsetY);
        }
        return destination;
    }


    public int distance(Location destination) {
        int xDist = Math.abs(destination.getX() - this.x);
        int yDist = Math.abs(destination.getY() - this.y);
        return Math.max(xDist, yDist);
    }
    

    public boolean equals(Object other) {
        if(other instanceof Location) {
            Location otherLocation = (Location) other;
            return this.x == otherLocation.getX() && this.y == otherLocation.getY();
        } 
        return false; 
    }
    

    public String toString() { return "location " + this.x + "," + this.y; }

    public int hashCode() { return (this.y << 16) + this.x; }

    public int getX() { return this.x; }

    public int getY() { return this.y; }
    
}
