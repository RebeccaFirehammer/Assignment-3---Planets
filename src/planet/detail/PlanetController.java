package planet.detail;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class PlanetController {
    FileChooser chooser = new FileChooser();
    
    Planet planet;

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
    
    private Double planetDiameterMValue;

    @FXML
    private TextField planetMeanSurfaceTempC;
    
    private Double planetMeanSurfaceTempCValue;

    @FXML
    private TextField planetMeanSurfaceTempF;
    
    private Double planetMeanSurfaceTempFValue;

    @FXML
    private TextField planetNumberOfMoons;
    
    private int planetNumberOfMoonsValue;

    @FXML
    private Label fancyPlanetName;
    
    void setPlanetValues(){
    	planetNameValue = planetName.getText();
    	planetDiameterKMValue = Double.parseDouble(planetDiameterKM.getText());
    	planetMeanSurfaceTempCValue = Double.parseDouble(planetMeanSurfaceTempC.getText());
    	planetNumberOfMoonsValue = Integer.parseInt(planetNumberOfMoons.getText());
    	planet = new Planet(planetNameValue, planetDiameterKMValue, planetMeanSurfaceTempCValue, planetNumberOfMoonsValue);
    }
    
    void generateConversionTextFields(){
    	planetDiameterMValue = planet.calculatePlanetDiameterM(planetDiameterKMValue);
    	planetDiameterM.setText(Double.toString(planetDiameterMValue));
    	
    	planetMeanSurfaceTempFValue = planet.calculatePlanetMeanSurfaceTempF(planetMeanSurfaceTempCValue);
    	planetMeanSurfaceTempF.setText(Double.toString(planetMeanSurfaceTempFValue));
    }
    @FXML
    void selectImage(ActionEvent event) {
        chooser.setTitle("Select Image");
        chooser.showOpenDialog(selectImageButton.getScene().getWindow());
    }
    
    @FXML    
    void loadPlanet(ActionEvent event) {   
        chooser.setTitle("Select Planet to Load");
        chooser.showOpenDialog(selectImageButton.getScene().getWindow());
    }

    @FXML    
    void savePlanet(ActionEvent event) {   
    	setPlanetValues();
    	generateConversionTextFields();
        chooser.setTitle("Select Location to Save Planet");
        chooser.showSaveDialog(selectImageButton.getScene().getWindow());
    }

}