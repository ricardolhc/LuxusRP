public abstract class Vehicle implements Actor {
	
	private LuxCompany company;
	private Location location;
	private Location targetLocation;
	
	public Vehicle(LuxCompany company, Location location) {
		//verifica se é nulo e passa um erro, se não for nulo ele atribui
		if(company == null) {
			throw new NullPointerException("company");
		}

		if(location == null) {
			throw new NullPointerException("location");
		}
		this.company = company;
		this.location = location;
		this.targetLocation = null;
	}

	//ele verifica a localizção se o parametro não for nulo ele aceita a localização
	public void setLocation(Location location) {
		if(location == null) {
			throw new NullPointerException();
		} 
		this.location = location;
	}
	
	//esse metodo verifica o destino do carro, se não for nulo ele atribui o destino
	public void setTargetLocation(Location location) {
		if(location == null) {
			throw new NullPointerException();
		}
		this.targetLocation = location;
	}

	public boolean isCar() {
		return this instanceof LuxCar;
	}

	public boolean isBus() {
		return this instanceof Shuttle;
	}

	//metodo abstrato quem estender da classe veiculo obrigatoriamente tera que possuir esses metodos
	public abstract void setPickupLocation(Location location);
	
	public abstract void pickup(Passenger passenger);
		
	public abstract boolean isFree();
		
	public abstract void offloadPassenger();

	public Location getLocation() { return this.location; }

	public void clearTargetLocation() { this.targetLocation = null; }

	public Location getTargetLocation() { return this.targetLocation; }

	public void notifyPickupArrival() { this.company.arrivedAtPickup(this); }
	
	public void notifyPassengerArrival(Passenger passenger) { this.company.arrivedAtDestination(this, passenger); }

}
