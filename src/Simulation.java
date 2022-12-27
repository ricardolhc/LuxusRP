import java.util.LinkedList;
import java.util.List;

public class Simulation {

    private List<Actor> actors;
    //private int step;

    
    //simula uma lista de actor para ser usado pela company e city
    public Simulation() {
        this.actors = new LinkedList<Actor>();
        //this.step = 0;
        City city = new City();
        LuxCompany company = new LuxCompany(city);
        PassengerSource source = new PassengerSource(city, company);
        
        this.actors.addAll(company.getVehicles());
        this.actors.add(source);
        this.actors.add(new CityGUI(city));
    }

    
    //determina a uma distancia para a area de criação do actor
    public void run() {
        for(int i = 0; i < 1000; i++){
            //this.step++;
            step();
            wait(100);
        }
    }

    public void step(){
        for(Actor actor : this.actors) {
            actor.act();
        }
    }

    private void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) { }
    }
    
}
