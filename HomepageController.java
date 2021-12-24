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

public class HomepageController implements Initializable {
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private RadioButton footballButton;
    @FXML
    private RadioButton basketballButton;
    @FXML
    private RadioButton tennisButton;
    @FXML
    private RadioButton heliopolisButton;
    @FXML
    private RadioButton nasrCityButton;
    @FXML
    private RadioButton fifthDistrictButton;
    @FXML
    private Button submitChoicesButton;
    @FXML
    private Label chooseeMessage;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField dayTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile= new File("images/unnamed.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        backgroundImageView.setImage(backgroundImage);
    }
    public void choose(){
        if(footballButton.isSelected()==false && basketballButton.isSelected()==false && tennisButton.isSelected()==false ){
            chooseeMessage.setText("Please choose a sport");
        }
        else if(nasrCityButton.isSelected()==false && heliopolisButton.isSelected()==false && fifthDistrictButton.isSelected()==false){
            chooseeMessage.setText("Please choose a location");
        }
        else if(footballButton.isSelected() && basketballButton.isSelected()){
            chooseeMessage.setText("Please choose one sport only");
        }
        else if(footballButton.isSelected() && tennisButton.isSelected()){
            chooseeMessage.setText("Please choose one sport only");
        }
        else if(tennisButton.isSelected() && basketballButton.isSelected()){
            chooseeMessage.setText("Please choose one sport only");
        }
        else if(footballButton.isSelected() && basketballButton.isSelected() && tennisButton.isSelected()){
            chooseeMessage.setText("Please choose one sport only");
        }
        else if(monthTextField.getText().isBlank() ||yearTextField.getText().isBlank() || dayTextField.getText().isBlank())
            chooseeMessage.setText("Please choose a Date");
        else if(Double.parseDouble(yearTextField.getText())!=21)
            chooseeMessage.setText("Reservation must be in this year");
        else if(Double.parseDouble(monthTextField.getText())>6 || Double.parseDouble(dayTextField.getText())>26)
            chooseeMessage.setText("Reservation must be within 14 days");
        else if(Double.parseDouble(monthTextField.getText())<6 || Double.parseDouble(dayTextField.getText())<12)
            chooseeMessage.setText("You can't choose a passed day");
        else if (footballButton.isSelected() && heliopolisButton.isSelected())
            goToHeliopolis();
        else if (footballButton.isSelected() && nasrCityButton.isSelected())
            goToCourts();
        else if (footballButton.isSelected() && fifthDistrictButton.isSelected())
            goToFifth();
        else if (basketballButton.isSelected())
            goToBasketball();
        else if (tennisButton.isSelected())
            goToTennis();
    }
    public void goToTennis(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Tennis.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToBasketball(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Basketball.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToCourts(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Court.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToFifth(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FifthFootball.fxml"));
            Stage registerStage= new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 570, 400));
            registerStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToHeliopolis(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("HeliopolisFootball.fxml"));
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
