package planet.detail;

public class Planet {
	
	private final String VALID_CHARS = "^[A-Za-z0-9 -.]+$";
	private final int MIN_NAME_LENGTH = 1;
	private final int MAX_NAME_LENGTH = 255;
	private final double MIN_DIAMETER = 0;
	private final double MAX_DIAMETER = 200000;
	private final double MIN_TEMP_C = -273.15;
	private final double MAX_TEMP_C = 500.0;
	private final int MIN_MOONS = 0;
	private final int MAX_MOONS = 1000;
	
    private String planetName;
	private String planetImagePath;
    private double planetDiameterKM;
    private double planetMeanSurfaceTempC;
    private int planetNumberOfMoons;
    
    
    public Planet(String planetName, double planetDiameterKM, double planetMeanSurfaceTempC,
			int planetNumberOfMoons) {
    	this.planetName = planetName;
    	this.planetDiameterKM = planetDiameterKM;
    	this.planetMeanSurfaceTempC = planetMeanSurfaceTempC;
    	this.planetNumberOfMoons = planetNumberOfMoons;
    }
    public Planet(String planetName, double planetDiameterKM, double planetMeanSurfaceTempC,
    				int planetNumberOfMoons, String planetImagePath) {
    	this.planetName = planetName;
    	this.planetDiameterKM = planetDiameterKM;
    	this.planetMeanSurfaceTempC = planetMeanSurfaceTempC;
    	this.planetNumberOfMoons = planetNumberOfMoons;
    	this.planetImagePath = planetImagePath;
    }
    
    public boolean isValidName(String planetName) {
    	return (planetName.length() >= MIN_NAME_LENGTH &&
    			planetName.length() <= MAX_NAME_LENGTH &&
    			planetName.matches(VALID_CHARS));
    }
    
    public boolean isValidDiameter(double planetDiameterKM) {
    	return (planetDiameterKM >= MIN_DIAMETER && 
    			planetDiameterKM <= MAX_DIAMETER);
    }
    
    public boolean isValidTemp(double planetMeanSurfaceTempC) {
    	return (planetMeanSurfaceTempC >= MIN_TEMP_C && 
    			planetMeanSurfaceTempC <= MAX_TEMP_C);
    }
    
    public boolean isValidNumberOfMoons(int planetNumberOfMoons) {
    	return (planetNumberOfMoons >= MIN_MOONS && 
    			planetNumberOfMoons <= MAX_MOONS);
    }
    
    public void setPlanetName(String planetName) {
    	if(isValidName(planetName)) {
    		this.planetName = planetName;
    	}
    }
    
    public void setPlanetImagePath(String planetImagePath){
    	this.planetImagePath = planetImagePath;
    }
    
    public void setPlanetDiameterKM(double planetDiameterKM) {
    	if(isValidDiameter(planetDiameterKM)) {
    		this.planetDiameterKM = planetDiameterKM;
    	}
    }
    
    public void setPlanetMeanSurfaceTempC(double planetMeanSurfaceTempC) {
    	if(isValidTemp(planetMeanSurfaceTempC)) {
    		this.planetMeanSurfaceTempC = planetMeanSurfaceTempC;
    	}
    }
    
    public void setPlanetNumberOfMoons(int planetNumberOfMoons) {
    	if(isValidNumberOfMoons(planetNumberOfMoons)) {
    		this.planetNumberOfMoons = planetNumberOfMoons;
    	}
    }
    
    public String getPlanetName() {
		return planetName;
	}
    
    public String getPlanetImagePath(){
    	return planetImagePath;
    }

	public double getPlanetDiameterKM() {
		return planetDiameterKM;
	}

	public double getPlanetMeanSurfaceTempC() {
		return planetMeanSurfaceTempC;
	}

	public int getPlanetNumberOfMoons() {
		return planetNumberOfMoons;
	}
    
}
