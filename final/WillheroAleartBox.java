package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static sample.constants.height;
import static sample.constants.width;

public class WillheroAleartBox {
    public void display(Label Text,Boolean b){
        Stage stage = new Stage();
        Image image1 = new Image("sample/assets/unnamed.png");
        stage.getIcons().add(image1);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Game Over");
        stage.setMinWidth(300);
        Button btn2 = null;
        Button btn1 = null;
        if (b) {
            btn1 = new willHeroButton("Yes");
            btn2 = new willHeroButton("save and return to main menu");
        }
        else{
            btn1 = new willHeroButton("No");
            btn2 = new willHeroButton("Yes");
        }

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setHeight(width);
                stage.setWidth(height);
                stage.show();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(Text,btn1,btn2);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,500,250);
        stage.setScene(scene);
        stage.show();
    }

}
