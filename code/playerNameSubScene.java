package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class playerNameSubScene extends willHeroSubScene{
    @FXML
    private TextField inputName;

    private String playerName;


    willHeroButton startButton;
    AnchorPane root;
    public playerNameSubScene(){
        Label label = new Label("Enter teh name of the player: ");
        playerName = inputName.getText().toString();
        prefWidth(300);
        prefHeight(300);
        createStartGameButton();
        label.setLocation(10,15);
        inputName.setLocation(15,15);
        startButton.setLayoutY(20);
        startButton.setLayoutX(20);
        root = (AnchorPane) this.getRoot();

//      root.getChildren().addAll(label,inputName,startButton);
    }

    public String getName(){
        return inputName.getText().toString();
    }
    public void createStartGameButton(){
        startButton = new willHeroButton("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (actionEvent.equals(MouseButton.PRIMARY)){
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("initializeNewGame.fxml")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setWidth(600);
                    stage.setHeight(600);
                    stage.show();
                }
            }
        });

        root2.getChildren().add(startButton);

    }
}
