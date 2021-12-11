package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Scene scene = new Scene(root,600, 600, Color.LIGHTBLUE);
        primaryStage.setTitle("Will Hero!");
        Image image1 = new Image("sample/unnamed.png");
        Image image2 = new Image("sample/Islands1.png");
        Image image3 = new Image("sample/Islands2.png");
        Image image4 = new Image("sample/Tree2.png");
        Image image5 = new Image("sample/blueOrc.jpg");
        Image image6 = new Image("sample/Islands3.png");
        Image image7 = new Image("sample/old_wind_turbines.jpg");
        Image image8 = new Image("sample/home.jpg");
        Image image9 = new Image("sample/Orc1.png");
        Image image10 = new Image("sample/Orc2.png");
        Image image11 = new Image("sample/Orc3.png");
        Image image12 = new Image("sample/RedOrc1.png");
        Image image13 = new Image("sample/ChestOpen.png");
        primaryStage.getIcons().add(image1);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
//        primaryStage.setFullScreen(true);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
