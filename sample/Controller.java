package sample;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView myImageCloud;
    @FXML
    private ImageView myAxe;
    @FXML
    private ImageView myOrc1;
    @FXML
    private ImageView myMill;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myImageCloud);
        translate.setDuration(Duration.millis(10000));
        translate.setByX(400);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(myOrc1);
        transition.setDuration(Duration.millis(700));
        transition.setByX(10);
        transition.setByY(-10);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(myAxe);
        rotateTransition.setDuration(Duration.millis(700));
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setByAngle(150);
        rotateTransition.play();
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myMill);
        rotate.setDuration(Duration.millis(700));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.play();
    }
    public void switchtonew(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newGame.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(600);
        stage.setHeight(600);
        stage.show();
    }
    public void switchtoresume(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newGame.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setHeight(600);
        stage.setWidth(600);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(600);
        stage.show();
    }
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
    public void switchtoscores(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewScores.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setHeight(600);
        stage.setWidth(600);
        Scene scene = new Scene(root, Color.MAGENTA);
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(600);
        stage.show();
    }
}
