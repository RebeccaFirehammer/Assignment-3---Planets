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

    @FXML
    private ImageView planetImage;

    @FXML
    private Button selectImageButton;

    @FXML
    private TextField planetName;

    @FXML
    private TextField planetDiameterKM;

    @FXML
    private TextField planetDiameterM;

    @FXML
    private TextField planetMeanSurfaceTempC;

    @FXML
    private TextField planetMeanSurfaceTempF;

    @FXML
    private TextField planetNumberOfMoons;

    @FXML
    private Label fancyPlanetName;

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
        chooser.setTitle("Select Location to Save Planet");
        chooser.showSaveDialog(selectImageButton.getScene().getWindow());
    }

}