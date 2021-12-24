package sample;
import java.time.LocalDate;
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
import java.util.Date;
import java.util.ResourceBundle;

public class VisaReqController implements Initializable {
    @FXML
    private Button confirmButton;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private TextField accountNumberTextField;
    @FXML
    private TextField cvvTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label visaMessageLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File backgroundFile = new File("images/unnamed.jpg");
        Image backgroundImage = new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
    public void visaButtonOnAction(ActionEvent event){
        if(cvvTextField.getText().isBlank()==false && accountNumberTextField.getText().isBlank()==false && monthTextField.getText().isBlank()==false && yearTextField.getText().isBlank()==false )
            validatePayment();
        else
            visaMessageLabel.setText("Please enter full information");
    }
    public void validatePayment(){

        if(cvvTextField.getLength()==3 && accountNumberTextField.getLength()==16 && accountNumberTextField.getText().startsWith("4") && yearTextField.getLength()==2 && (monthTextField.getLength()==2 ||monthTextField.getLength()==1) && ((Double.parseDouble(monthTextField.getText())>6 && Double.parseDouble(yearTextField.getText())>20)||Double.parseDouble(yearTextField.getText())>20)){

            goToFinal();
        }
        else if(cvvTextField.getLength()!=3)
            visaMessageLabel.setText("CVV must be 3 numbers");
        else if(accountNumberTextField.getLength()!=16)
            visaMessageLabel.setText("Account Number must be 16 numbers");
        else if(accountNumberTextField.getText().startsWith("4")==false)
            visaMessageLabel.setText("Account Number must start with 4");
        else if(Double.parseDouble(monthTextField.getText())>12 ||Double.parseDouble(monthTextField.getText()) <1)
            visaMessageLabel.setText("This month is not valid");
        else if((Double.parseDouble(monthTextField.getText())<21))
            visaMessageLabel.setText("The VISA is expired");
        else if((Double.parseDouble(monthTextField.getText())<7)&& (Double.parseDouble(monthTextField.getText())<21))
            visaMessageLabel.setText("The VISA is expired");
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
