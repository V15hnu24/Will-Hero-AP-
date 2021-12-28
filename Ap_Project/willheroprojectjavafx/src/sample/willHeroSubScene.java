package sample;

import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class willHeroSubScene extends SubScene {
    AnchorPane root2;
    public willHeroSubScene() {
        super(new AnchorPane(),600,400);
        prefWidth(300);
        prefHeight(300);

//        BackgroundImage img = new BackgroundImage(new Image("sample/Helmet1.png",600,400,false,true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,null);

        root2 = (AnchorPane) this.getRoot();


//        root2.setBackground(new Background(img));
    }

    public void createStartGameButton(){

        willHeroButton startButton = new willHeroButton("Start");
        root2.getChildren().add(startButton);
    }
}
