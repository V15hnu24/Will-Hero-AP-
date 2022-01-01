package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.Objects;

import static sample.constants.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Will Hero!");
        Image image1 = new Image("sample/assets/unnamed.png");

        Scene scene = new Scene(root,width, height, Color.LIGHTBLUE);

        scene.getStylesheets().add(getClass().getResource("java.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(image1);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}