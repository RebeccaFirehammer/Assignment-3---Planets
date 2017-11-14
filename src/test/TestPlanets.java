package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import planet.detail.Planet;

public class TestPlanets {
	
	protected Planet planet;
	protected String planetName;
	protected String planetImagePath;
	protected double planetDiameterKM;
	protected double planetMeanSurfaceTempC;
	protected int planetNumberOfMoons;
	
	@Before
	public void setUpPlanet()
	{
		String planetName = "Jupiter";
		String planetImagePath = "/images/no_image.png";
		double planetDiameterKM = 500.5;
		double planetMeanSurfaceTempC = 500.5;
		int planetNumberOfMoons = 5;
		planet = new Planet(planetName, planetDiameterKM, planetMeanSurfaceTempC, planetNumberOfMoons, planetImagePath);
	}
	
	@Test
	public void testSetPlanetDiameter() {
		planetDiameterKM = 500.5;
	    planet.setPlanetDiameterKM(planetDiameterKM);
	    assertEquals(planetDiameterKM, planet.getPlanetDiameterKM(), 0);
	}
	
	@Test
	public void testSetPlanetMeanSurfaceTempF() {
		planetMeanSurfaceTempC = 500.5;
	    planet.setPlanetMeanSurfaceTempC(planetMeanSurfaceTempC);
	    assertEquals(planetMeanSurfaceTempC, planet.getPlanetMeanSurfaceTempC(), 0);
	}

	@Test
	public void testIsValidName() {
		String planetName = "Neptune";
		planet.setPlanetName(planetName);
		assertEquals(true, planet.isValidName(planetName));
	}
		
	@Test
	public void testGetPlanetImagePath() {
		String planetImagePath = "/images/neptune.png";
		planet.setPlanetImagePath(planetImagePath);
		assertEquals(planetImagePath, planet.getPlanetImagePath());
	}
	
	@Test
	public void testIsValidDiameter() {
		Double diameter = 500.5;
		assertEquals(true, planet.isValidDiameter(diameter));
	}
	
	@Test
	public void testIsValidTemp() {
		Double temp = 499.5;
		assertEquals(true, planet.isValidTemp(temp));
	}
	
	@Test
	public void testIsValidNumberOfMoons() {
		int moons = 5;
		assertEquals(true, planet.isValidNumberOfMoons(moons));
	}
	
	@Test
	public void testGetPlanetName() {
		String planetName = "Jupiter";
		planet.setPlanetName(planetName);
		assertEquals(planetName, planet.getPlanetName());
	}
	
	@Test
	public void testGetPlanetDiameter() {
		Double diameter = 500.5;
		planet.setPlanetDiameterKM(diameter);
		assertEquals(diameter, planet.getPlanetDiameterKM(), 0);
	}
	
	@Test
	public void testGetPlanetMeanSurfaceTempC() {
		Double temp = 500.5;
		planet.setPlanetMeanSurfaceTempC(temp);
		assertEquals(temp, planet.getPlanetMeanSurfaceTempC(), 0);
	}
	
	@Test
	public void testGetPlanetNumberOfMoons() {
		int moons = 5;
		planet.setPlanetNumberOfMoons(moons);
		assertEquals(moons, planet.getPlanetNumberOfMoons(), 0);
	}
	

}
