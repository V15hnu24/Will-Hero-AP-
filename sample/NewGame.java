package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewGame implements Initializable {
    public void switchtosettings(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setHeight(600);
        stage.setWidth(600);
        Scene scene = new Scene(root, Color.MAGENTA);
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(600);
        stage.show();
    }
    private Parent root;
    @FXML
    private ImageView myUser;
    @FXML
    private ImageView myCloud;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myUser);
        translate.setDuration(Duration.millis(700));
        translate.setByY(-50);
        translate.setAutoReverse(true);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(myCloud);
        translate1.setDuration(Duration.millis(10000));
        translate1.setByX(350);
        translate1.setCycleCount(TranslateTransition.INDEFINITE);
        translate1.play();
    }
}
