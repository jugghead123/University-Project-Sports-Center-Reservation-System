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
public class ManagerLoginController implements Initializable{
    String s1="Mohamed";
    String s2="aaaaaaaa";
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private Button loginButton;
    @FXML
    private Button closeButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label loginMessageLabel;
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/unnamed.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
    public void closeButtonOnAction(ActionEvent event){
        Stage stage= (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void loginButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false){
            validateLogin();
        }else
            loginMessageLabel.setText("Please enter username and password");
    }
    public void validateLogin(){
        if (usernameTextField.getText().equals(s1) && passwordTextField.getText().equals(s2))
            goToManagerChoices();
        else
            loginMessageLabel.setText("Invalid username or Password");

    }
    public void goToManagerChoices(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ManagerChoices.fxml"));
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
