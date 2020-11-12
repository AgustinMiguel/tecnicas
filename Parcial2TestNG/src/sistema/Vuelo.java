package sistema;

import java.util.ArrayList;

public class Vuelo {
	private ArrayList<Pasajero> asientos;
	private int capacidad;
	
	
	
	
	public Vuelo(int capacidad) {
		this.asientos = new ArrayList<Pasajero>();
		this.capacidad = capacidad;
	} 
	
	public void addPasajero(Pasajero pasajero) {
		asientos.add(pasajero);
	}
	
	public int getLugaresvacios() {
		return capacidad - asientos.size(); 
	}
	
}


