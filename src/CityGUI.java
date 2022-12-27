import java.util.List;
import java.awt.*;
import javax.swing.*;

public class CityGUI extends JFrame implements Actor {
    
    private City city;
    private CityView cityView;

    public static final int CITY_VIEW_WIDTH = 600;
    public static final int CITY_VIEW_HEIGHT = 600;
    
    public CityGUI(City city) {
        this.city = city;
        this.cityView = new CityView(city.getWidth(), city.getHeight());
        getContentPane().add(this.cityView);
        setTitle("LUXUS");
        setSize(CITY_VIEW_WIDTH, CITY_VIEW_HEIGHT);
        setVisible(true);
        this.cityView.preparePaint();
        this.cityView.repaint();    
    }

    public void act() {
        this.cityView.preparePaint();
        List<Object> items = this.city.getItems();
        for(Object obj : items) {
            if(obj instanceof DrawableItem){
                DrawableItem item = (DrawableItem) obj;
                Location location = item.getLocation();
                this.cityView.drawImage(location.getX(), location.getY(), item.getImage());
            }
        }
        this.cityView.repaint();    
    }
    

    private class CityView extends JPanel {

        private final int VIEW_SCALING_FACTOR = 6;

        private int cityWidth, cityHeight;
        private int xScale, yScale;
        private Dimension size;
        private Graphics g;
        private Image cityImage;

        public CityView(int width, int height) {
            this.cityWidth = width;
            this.cityHeight = height;
            setBackground(Color.white);
            this.size = new Dimension(0, 0);
        }


        public Dimension getPreferredSize() {
            return new Dimension(this.cityWidth * VIEW_SCALING_FACTOR, this.cityHeight * VIEW_SCALING_FACTOR);
        }
        

        public void preparePaint() {

            if(!this.size.equals(getSize())) {  // if the size has changed...
                this.size = getSize();
                this.cityImage = cityView.createImage(size.width, size.height);
                this.g = cityImage.getGraphics();

                this.xScale = this.size.width / this.cityWidth;
                if(xScale < 1) {
                    this.xScale = VIEW_SCALING_FACTOR;
                }

                this.yScale = this.size.height / this.cityHeight;
                if(this.yScale < 1) {
                    this.yScale = VIEW_SCALING_FACTOR;
                }
            }

            this.g.setColor(Color.white);
            this.g.fillRect(0, 0, this.size.width, this.size.height);
            this.g.setColor(Color.gray);

            for(int i = 0, x = 0; x < this.size.width; i++, x = i * this.xScale) {
                this.g.drawLine(x, 0, x, size.height - 1);
            }

            for(int i = 0, y = 0; y < this.size.height; i++, y = i * this.yScale) {
                this.g.drawLine(0, y, this.size.width - 1, y);
            }

        }
        
   
        public void drawImage(int x, int y, Image image) {
            this.g.drawImage(image, x * this.xScale + 1, y * this.yScale + 1, this.xScale - 1, this.yScale - 1, this);
        }

   
        public void paintComponent(Graphics g) {
            if(this.cityImage != null) {
                Dimension currentSize = getSize();
                if(this.size.equals(currentSize)) {
                    g.drawImage(this.cityImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(this.cityImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
        
    }
}
