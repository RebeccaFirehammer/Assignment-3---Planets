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

public class PlanetBuilder {
	
    private FileWriter writer;
	
	void generateFile(File file, Planet planet){
    	String newLine = System.lineSeparator();
    	System.out.println("flag2");
		try {
			writer = new FileWriter(file);
			System.out.println("flag1");
			writer.write(
					planet.getPlanetName() + newLine +
					planet.getPlanetDiameterKM() + newLine +
					planet.getPlanetMeanSurfaceTempC() + newLine +
					planet.getPlanetNumberOfMoons() + newLine +
					planet.getPlanetImagePath()
			);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
