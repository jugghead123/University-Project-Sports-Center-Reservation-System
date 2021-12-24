package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.Character.isDigit;

public class CustomerRegisterController implements Initializable {

    @FXML
    private ImageView backgroundImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label registrationMessageLabel;

    public void closeButtonOnAction(ActionEvent event){
        Stage stage= (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void registerButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false && confirmPasswordTextField.getText().isBlank()==false && nameTextField.getText().isBlank()==false && phoneTextField.getText().isBlank()==false){
            validateRegistration();
        }else
            registrationMessageLabel.setText("Please enter full information");

    }
    public boolean checkNumber() {
        if (phoneTextField.getLength() == 11 && phoneTextField.getText().startsWith("0")) {
            String str = phoneTextField.getText();
            if (isDigit(str.charAt(0)) == true && isDigit(str.charAt(1)) == true && isDigit(str.charAt(2)) == true && isDigit(str.charAt(3)) == true && isDigit(str.charAt(4)) == true && isDigit(str.charAt(5)) == true && isDigit(str.charAt(6)) == true && isDigit(str.charAt(7)) == true && isDigit(str.charAt(8)) == true && isDigit(str.charAt(9)) == true && isDigit(str.charAt(0)) == true)
                return true;
        }
        return false;
    }
    public void validateRegistration(){

        if(passwordTextField.getText().equals(confirmPasswordTextField.getText()) && usernameTextField.getText().equals("Hamza")==false && checkNumber()==true)
            goToLoginForm();

        else  if (passwordTextField.getText().equals(confirmPasswordTextField.getText())==false)
            registrationMessageLabel.setText("Password does not match");
        else if(usernameTextField.getText().equals("Hamza"))
            registrationMessageLabel.setText("Username is already taken");
        else if(checkNumber()==false)
            registrationMessageLabel.setText("Phone must be 11 digit number starting with 0");
    }
    public void goToLoginForm(){
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgroundFile = new File("images/unnamed.jpg");
        Image backgroundImage = new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
}