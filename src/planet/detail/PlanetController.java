package planet.detail;

import java.awt.image.BufferedImage;
import java.io.File;
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
    FileChooser chooser = new FileChooser();
    
    Planet planet;
    
	private final double MILES_IN_KM = 0.621371;

    @FXML
    private ImageView planetImage;

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
    
    void setPlanetValues(){
    	planetNameValue = planetName.getText();
    	planetDiameterKMValue = Double.parseDouble(planetDiameterKM.getText());
    	planetMeanSurfaceTempCValue = Double.parseDouble(planetMeanSurfaceTempC.getText());
    	planetNumberOfMoonsValue = Integer.parseInt(planetNumberOfMoons.getText());
    	planet = new Planet(planetNameValue, planetDiameterKMValue, planetMeanSurfaceTempCValue, planetNumberOfMoonsValue);
    }
    
    @FXML
    void selectImage(ActionEvent event) {
        setImageFilter();
        chooser.setTitle("Select Image");
        File file = chooser.showOpenDialog(selectImageButton.getScene().getWindow());
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            planetImage.setImage(image);
        } catch (IOException ex) {
        	System.err.println("Invalid Image.");
        }
    }
    
    void setImageFilter(){
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        chooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
    }
    
    @FXML    
    void loadPlanet(ActionEvent event) {   
        chooser.setTitle("Select Planet to Load");
        chooser.showOpenDialog(selectImageButton.getScene().getWindow());
    }

    @FXML    
    void savePlanet(ActionEvent event) {   
    	setPlanetValues();
        chooser.setTitle("Select Location to Save Planet");
        chooser.showSaveDialog(selectImageButton.getScene().getWindow());
    }

}