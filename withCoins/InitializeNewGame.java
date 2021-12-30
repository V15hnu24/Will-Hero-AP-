package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static sample.constants.*;

public class InitializeNewGame implements Initializable{

    @FXML
    private Button startGameButton;

    @FXML
    private TextField inputName;

    private String name;
    @FXML
    public void switchToNewGame(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newGame.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setHeight(height);
        stage.setWidth(width);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        name = inputName.getText();
        System.out.println(name.toString());

        gameState newGame = new gameState();
        newGame.setPlayerName(name);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startGameButton = new willHeroButton("Start game");
        inputName = new TextField();

    }
}
