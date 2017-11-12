package planet.detail;

import java.util.List;

abstract class PlanetFactory {
	public List<Planet> planets;
	
	public List<Planet> createPlanets(){
		return this.planets;
	}
}
