package sample;

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

public class willHeroButton extends Button {
    private String font_Path = "sample/fontStyle.ttf";
    private String button_pressed_style = "-fx-background-color: transparent; -fx-background-image: url('sample/Coin.png');";
    private String button_free_style = "-fx-background-color: transparent; -fx-background-image: url('sample/Coin.png');";

    public willHeroButton(String text){
        setText(text);
        setStyle("-fx-text-fill: white");
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(button_free_style);
        intializeButtonListener();
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(font_Path),23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana",23));
        }
    }

    private void setButtonPressedStyle(){
        setStyle(button_pressed_style);
        setPrefHeight(45);
        //setLayoutY(getLayoutX()+4);
    }

    private void setButtonReleasedStyle(){
        setStyle(button_free_style);
        setPrefHeight(49);
        //setLayoutY(getLayoutX() -4);
    }

    private void intializeButtonListener(){

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressedStyle();
                }
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonReleasedStyle();
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setEffect(new DropShadow());
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setEffect(null);
                }
            }
        });
    }


}
