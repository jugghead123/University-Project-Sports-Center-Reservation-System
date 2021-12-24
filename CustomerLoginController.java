package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerLoginController implements Initializable {
    String s1="Hamza";
    String s2="aaaaaaaa";
    @FXML
    private Button cancelButton;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private TextField usernameTextField;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField passwordTextField;
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/unnamed.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
    public void createAccountForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("CustomerRegister.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void loginButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false){
            validateLogin();
        }else
            loginMessageLabel.setText("Please enter username and password");
    }
    public void validateLogin(){
        if (usernameTextField.getText().equals(s1) && passwordTextField.getText().equals(s2))
            choicesForm();
        else
            loginMessageLabel.setText("Invalid username or Password");

    }
    public void choicesForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
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
