package planet.detail;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class PlanetController {
	
	private Planet planet; 
	
	private PlanetBuilder builder = new PlanetBuilder();
	
    private FileChooser chooser = new FileChooser();
    
    private FileReader reader;
    
    private BufferedReader buffer;
    
	private final double MILES_IN_KM = 0.621371;

    @FXML
    private ImageView planetImage;
    
    private Image loadImage;
    
    private String planetImagePathValue;
    
    private Image defaultImage;
    
    private String defaultImagePathValue = "/images/no_image.png";
    
    @FXML
    private Button selectImageButton; 

    @FXML
    private TextField planetName;
    
    private String planetNameValue;

    @FXML
    private TextField planetDiameterKM;
    
    private Double planetDiameterKMValue;

    @FXML
    private TextField planetDiameterM;

    @FXML
    private TextField planetMeanSurfaceTempC;
    
    private Double planetMeanSurfaceTempCValue;

    @FXML
    private TextField planetMeanSurfaceTempF;

    @FXML
    private TextField planetNumberOfMoons;
    
    private int planetNumberOfMoonsValue;

    @FXML
    private Label fancyPlanetName;
    
    public void initialize(){
    	addTextFieldListeners();
    	defaultImage = new Image(defaultImagePathValue);
    	planetImage.setImage(defaultImage);
    }
    
    void addTextFieldListeners(){
    	planetName.textProperty().addListener((obs, oldText, newText) -> {
    	    fancyPlanetName.setText(newText);
    	});
    	planetMeanSurfaceTempC.textProperty().addListener((obs, oldText, newText) -> {
    		try{
    			planetMeanSurfaceTempF.setText(Double.toString(calculatePlanetMeanSurfaceTempF(Double.parseDouble(newText))));
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Temperature value.");
    		}
    	});
    	planetDiameterKM.textProperty().addListener((obs, oldText, newText) -> {
    		try {
    			planetDiameterM.setText(Double.toString(calculatePlanetDiameterM(Double.parseDouble(newText))));
    		} catch (NumberFormatException e){
    			System.err.println("Invalid Diameter value.");
    		}
    	});
    }
    
    public double calculatePlanetDiameterM(double planetDiameterKM) {
    	return (planetDiameterKM * MILES_IN_KM);
    }
    
    public double calculatePlanetMeanSurfaceTempF(double planetMeanSurfaceTempC) {
    	return ((planetMeanSurfaceTempC * 9) / 5 + 32);
    }
    
    void setPlanetValuesFromWindow(){
    	planetNameValue = planetName.getText();
    	planetDiameterKMValue = Double.parseDouble(planetDiameterKM.getText());
    	planetMeanSurfaceTempCValue = Double.parseDouble(planetMeanSurfaceTempC.getText());
    	planetNumberOfMoonsValue = Integer.parseInt(planetNumberOfMoons.getText());
    	planet = new Planet(planetNameValue, planetDiameterKMValue, planetMeanSurfaceTempCValue, planetNumberOfMoonsValue, planetImagePathValue);
    }
    
    void setPlanetValuesFromFile(String name, String diameter, String temp, String moons, String path){
    	planetNameValue = name;
    	planetDiameterKMValue = Double.parseDouble(diameter);
    	planetMeanSurfaceTempCValue = Double.parseDouble(temp);
    	planetNumberOfMoonsValue = Integer.parseInt(moons);
    	if (path != null){
    		planetImagePathValue = path;
    		loadImage(defaultImagePathValue);
    	} else{
    		loadImage(planetImagePathValue);
    	}
    }
    
    void loadImage(String path){
    	try {
			BufferedImage img = ImageIO.read(new File(path));
			Image image = SwingFXUtils.toFXImage(img, null);
			planetImage.setImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    void loadFields(){
    	planetName.setText(planetNameValue);
    	planetDiameterKM.setText(planetDiameterKMValue.toString());
    	planetMeanSurfaceTempC.setText(planetMeanSurfaceTempCValue.toString());
    	planetNumberOfMoons.setText(String.valueOf(planetNumberOfMoonsValue));	
    }
    
    @FXML
    void selectImage(ActionEvent event) {
        setImageFilter();
        chooser.setTitle("Select Image");
        File file = chooser.showOpenDialog(selectImageButton.getScene().getWindow());
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            planetImagePathValue = file.getPath();
            planetImage.setImage(image);
        } catch (IOException ex) {
        	System.err.println("Invalid Image.");
        }
    }
    
    void setImageFilter(){
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        chooser.getExtensionFilters().setAll(extFilterJPG, extFilterPNG);
    }
    
    @FXML    
    void loadPlanet(ActionEvent event) {   
    	setTextFilter();
        chooser.setTitle("Select Planet to Load");
        File file = chooser.showOpenDialog(selectImageButton.getScene().getWindow());
        if(file != null){
        	loadFile(file);
        }
    }
    
    void loadFile(File file){
    	int numberOfLines = 5;
    	String[] planetData = new String[numberOfLines];
    	try {
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			
			for (int i = 0; i < numberOfLines; i++){
					planetData[i] = buffer.readLine();
			}
			setPlanetValuesFromFile(planetData[0], planetData[1], planetData[2], planetData[3], planetData[4]);
			loadFields();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }

    @FXML    
    void savePlanet(ActionEvent event) {   
    	setPlanetValuesFromWindow();
    	setTextFilter(); 
        chooser.setTitle("Select Location to Save Planet");
        File file = chooser.showSaveDialog(selectImageButton.getScene().getWindow());
        builder.generateFile(file, planet);
    }
    
    void setTextFilter(){
    	 FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.TXT");
         chooser.getExtensionFilters().setAll(extFilterTXT);
    }
    
    

}