package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class PaymentPageController implements Initializable {

    @FXML
    private ImageView backgroundImageView;
    @FXML
    private ImageView visaImageView;
    @FXML
    private Button cashButton;
    @FXML
    private Button visaButton;
    @FXML
    private Label amount;
    public void setAmount(String text){
        amount.setText(text);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgroundFile = new File("images/unnamed.jpg");
        Image backgroundImage = new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
        File visaFile = new File("images/visa-768x430.jpg");
        Image visaImage = new Image(visaFile.toURI().toString());
        visaImageView.setImage(visaImage);
    }
    public void putVisaReq(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("VisaReq.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToFinal(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Final.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
