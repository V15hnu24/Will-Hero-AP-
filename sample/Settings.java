package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class Settings {
    private Parent root;
    @FXML
    private Button exit;
    @FXML
    private AnchorPane scene;
    Stage stage;
    @FXML
    private CheckBox sound;
    @FXML
    private Label myTell;
    @FXML
    public void exitt(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Your game will be saved");
        alert.setContentText("Are you sure you want to exit?");
        if(alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) scene.getScene().getWindow();
            System.out.println("You have exited the game");
            stage.close();
        }
    }
    public void sound(ActionEvent event){
        if(sound.isSelected()){
            System.out.println("Sound is ON");
            myTell.setText("ON");
        }
        else {
            System.out.println("Sound is OFF");
            myTell.setText("OFF");
        }
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
