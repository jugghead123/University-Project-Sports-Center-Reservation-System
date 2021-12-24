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
public class GeneralController implements Initializable{
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private Button generalCustomerLoginButton;
    @FXML
    private Button generalManagerLoginButton;
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/unnamed.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
    public void goToCustomerLogin(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToManagerLogin(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
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
