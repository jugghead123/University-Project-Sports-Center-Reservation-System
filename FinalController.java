package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
public class FinalController implements Initializable {
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private Label amount;
    public void setAmounts(String text){
        amount.setText(text);
    }
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/unnamed.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
}
