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
public class FifthFootballController implements Initializable {
    @FXML
    private ImageView backgroundImageView;


    @FXML
    private RadioButton championsButton;
    @FXML
    private RadioButton diyarButton;
    @FXML
    private Button payButton;
    @FXML
    private TextField timeoneTextField;
    @FXML

    private TextField timetwoTextField;
    @FXML
    private Label courtMessage;
    String s;
    public void chooseCourt(){
        if(championsButton.isSelected()==false && diyarButton.isSelected()==false){
            courtMessage.setText("Please choose a court");
        }
        else if(timetwoTextField.getText().isBlank() || timeoneTextField.getText().isBlank())
            courtMessage.setText("Please choose reservation time");
        else if(championsButton.isSelected() && diyarButton.isSelected())
            courtMessage.setText("Please choose one court only");
        else if (championsButton.isSelected()) {
            double x=Double.parseDouble(timeoneTextField.getText());
            double y=Double.parseDouble(timetwoTextField.getText());
            if(y<x){
                y+=12;
            }
            double z=Math.abs(x-y)*150;
            s=String.valueOf(z);
            goToPayment();

        }
        else if (diyarButton.isSelected()) {
            double x=Double.parseDouble(timeoneTextField.getText());
            double y=Double.parseDouble(timetwoTextField.getText());
            if(y<x){
                y+=12;
            }
            double z=Math.abs(x-y)*180;
            s=String.valueOf(z);
            goToPayment();

        }
    }
    public void goToPayment(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("PaymentPage.fxml"));
            Parent root=(Parent) loader.load();
            PaymentPageController paymentPageController=loader.getController();
            paymentPageController.setAmount(s);
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/Capture.PNG");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);

    }
}
