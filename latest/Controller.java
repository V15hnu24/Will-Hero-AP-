package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static sample.constants.*;

public class Controller implements Initializable {

    private String font_Path = "sample/fontStyle.ttf";
    private String button_pressed_style = "-fx-background-color: transparent; -fx-background-image: url('sample/Coin.png');";
    private String button_free_style = "-fx-background-color: transparent; -fx-background-image: url('sample/Coin.png');";

    @FXML
    private ImageView myImageCloud;

    @FXML
    private ImageView myAxe;

    @FXML
    private ImageView hero;

    @FXML
    private ImageView coin1;

    @FXML
    private ImageView coin2;

    @FXML
    private ImageView myMill;

    @FXML
    private Button newGameButton;

    @FXML
    private Button resumegameButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button viewScoresButton;

    @FXML
    private ImageView myIsland2;

    private String playerName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        newGameButton = new willHeroButton("New Game");
        resumegameButton = new willHeroButton("Resume Game");
        settingsButton = new willHeroButton("Settings");
        viewScoresButton = new willHeroButton("High Score");

        cloudMovement cldMmt = new cloudMovement(myImageCloud);

        coinRotate coin1_r = new coinRotate(coin1);
        coinRotate coin2_r = new coinRotate(coin2);

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hero);
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

        /*
        playerNameSubScene ply = new playerNameSubScene();
        setPlayerName( ply.getName());
        willHeroSubScene playerNameSubScene = new willHeroSubScene();
        playerNameSubScene.setHeight(300);
        playerNameSubScene.setWidth(300);
        */

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("initializeNewGame.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.show();
    }

    public void switchtoresume(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newGame.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(width);
        stage.setWidth(height);
        root.setOnMouseMoved(
                (evt) -> {
                    System.out.println(evt.getX() + " " + evt.getY());
                }
        );
        stage.show();
    }

    public void switchtosettings(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.show();
    }

    public void switchtoscores(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewScores.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.show();
    }

    private void setButtonPressedStyle(Button button) {
        button.setStyle(button_pressed_style);
        button.setPrefHeight(45);
        //setLayoutY(getLayoutX()+4);
    }

    private void setButtonReleasedStyle(Button button) {
        button.setStyle(button_free_style);
        button.setPrefHeight(49);
        //setLayoutY(getLayoutX() -4);
    }

    private void buttonStyle(Button button) {

        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    button.setEffect(new DropShadow());
                }
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    button.setEffect(null);
                }
            }
        });

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
/*
class coinRotate{

    ImageView image;
    public coinRotate(ImageView img){
        this.image = img;
        RotateTransition transition1 = new RotateTransition();
        transition1.setNode(image);
        transition1.setByAngle(360);
        transition1.setAxis(new Point3D(0,1,0));
        transition1.setDuration(Duration.millis(500));
        transition1.setAutoReverse(true);
        transition1.setCycleCount(RotateTransition.INDEFINITE);
        transition1.play();
    }
}

 */