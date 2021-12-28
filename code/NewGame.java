package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewGame implements Initializable {

    @FXML
    private Group greenOrc;

    @FXML
    private ImageView greenOrc1;

    @FXML
    private ImageView greenOrc2;

    @FXML
    private ImageView greenOrc3;

    @FXML
    private ImageView greenOrc4;

    @FXML
    private ImageView greenOrc5;

    @FXML
    private ImageView hero;

    @FXML
    private ImageView cloud;

    @FXML
    private ImageView island11;

    @FXML
    private ImageView island13;

    @FXML
    private ImageView island1;

    @FXML
    private ImageView island10;

    @FXML
    private ImageView island12;

    @FXML
    private ImageView island14;

    @FXML
    private ImageView island2;

    @FXML
    private ImageView island3;

    @FXML
    private ImageView island4;

    @FXML
    private ImageView island5;

    @FXML
    private ImageView island6;

    @FXML
    private ImageView island7;

    @FXML
    private ImageView island8;

    @FXML
    private ImageView island9;

    @FXML
    private Button moveButton;

    @FXML
    private AnchorPane pane;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ImageView redOrc1;

    @FXML
    private ImageView redOrc2;

    @FXML
    private ImageView redOrc3;

    @FXML
    private ImageView redOrc4;

    @FXML
    private ImageView redOrc6;

    @FXML
    private ImageView redOrc7;

    @FXML
    private Group redOrcs;

    @FXML
    private Label number_OfMoves;

    @FXML
    private Group treeGroup;
    
    private int heroPosX;
    private int heroPosY;

    int l1x,l1y,l2x,l2y,l3x,l3y,l4x,l4y,l5x,l5y,l6x,l6y,l7x,l7y;
    int l8x,l8y,l9x,l9y,l10x,l10y,l11x,l11y,l12x,l12y,l13x,l13y,l14x,l14y;

    int nOfMoves = 0;

    @FXML
    void screenMovement(ActionEvent event) {
        nOfMoves++;
/*
        if (nOfMoves<6){
            hero.setX(heroPosX= heroPosX + 50);
        }
 */
        number_OfMoves.setText("Location : " + nOfMoves);

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(redOrcs);
        translate2.setDuration(Duration.millis(100));
        translate2.setByX(-50);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(greenOrc);
        translate3.setDuration(Duration.millis(100));
        translate3.setByX(-50);
        translate3.play();

        island1.setX(l1x = l1x-50);
        island2.setX(l2x = l2x-50);
        island3.setX(l3x = l3x-50);
        island4.setX(l4x = l4x-50);
        island5.setX(l5x = l5x-50);
        island6.setX(l6x = l6x-50);
        island7.setX(l7x = l7x-50);
        island8.setX(l8x = l8x-50);
        island9.setX(l9x = l9x-50);
        island10.setX(l10x = l10x-50);
        island11.setX(l11x = l11x-50);
        island12.setX(l12x = l12x-50);
        island13.setX(l13x = l13x-50);
        island14.setX(l14x = l14x-50);

        /*
        TranslateTransition translate4 = new TranslateTransition();
        translate4.setNode(islands);
        translate4.setDuration(Duration.millis(100));
        translate4.setByX(-50);
        translate4.play();
         */
        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(redOrcs);
        translate5.setDuration(Duration.millis(100));
        translate5.setByX(-50);
        translate5.play();

/*
        TranslateTransition heroMovement = new TranslateTransition();
        heroMovement.setNode(hero);
        heroMovement.setDuration(Duration.millis(200));
        heroMovement.setByX(50);
        heroMovement.play();

        TranslateTransition moveButtonMovement = new TranslateTransition();
        moveButtonMovement.setNode(moveButton);
        moveButtonMovement.setByX(50);
        moveButtonMovement.play();
 */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        TranslateTransition heroMovement = new TranslateTransition();
        heroMovement.setNode(hero);
        heroMovement.setDuration(Duration.millis(600));
        heroMovement.setByY(159);
        heroMovement.setAutoReverse(true);
        heroMovement.setCycleCount(TranslateTransition.INDEFINITE);
        heroMovement.play();
        hero.setX(heroPosX);
        hero.setY(heroPosY);
        */

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(greenOrc);
        transition.setDuration(Duration.millis(600));
        transition.setByY(-139);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();

        cloudMovement cldMmt = new cloudMovement(cloud);

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setNode(redOrcs);
        transition2.setDuration(Duration.millis(600));
        transition2.setByY(99);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.play();

        collision();

    }

    private int dy = 4;
    private double time = 40;
    private int n = 0;

    private void collision() {

        if (n>0){
            time = time * 2;
        }

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(time),
                (evt) -> {
                    hero.setY(hero.getY() + dy);

                    if (hero.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
                        dy = -dy;
                    }

                    if (hero.getBoundsInParent().intersects(island1.getBoundsInParent())) {
                        System.out.println("Collided");
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island2.getBoundsInParent())) {
                        dy = -dy;
                    }

                    else if (hero.getBoundsInParent().intersects(island3.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island4.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island5.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island6.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island7.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island8.getBoundsInParent())) {
                        dy = -dy;
                    }

                    else if (hero.getBoundsInParent().intersects(island9.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island10.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island12.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island11.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island13.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island14.getBoundsInParent())) {
                        dy = -dy;
                    }

                }
        ));
        n++;
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void 
}


/*
public class NewGame implements Initializable {

    private Parent root;

    private Group greenOrcs;
    private Group redOrcs;

    @FXML
    private ImageView hero;

    @FXML
    private Group back_Group;

    @FXML
    private Button moveButton;

    @FXML
    private ImageView myChest111;

    @FXML
    private ImageView myGreenOrc111;

    @FXML
    private ImageView myGreenOrc1111;

    @FXML
    private ImageView myIsland411;

    @FXML
    private ImageView myIsland511;

    @FXML
    private ImageView myIsland5111;

    @FXML
    private ImageView myIsland5211;

    @FXML
    private ImageView myIsland52111;

    @FXML
    private ImageView myIsland521111;

    @FXML
    private ImageView myIsland5211111;

    @FXML
    private ImageView myRedOrc111;

    @FXML
    private ImageView myRedOrc1111;

    @FXML
    private ImageView myRedOrc11111;

    @FXML
    private ImageView myTree111;

    @FXML
    private ImageView myTree211;

    private double x1;
    private double x2;

    public void switchtosettings(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root,width,height, Color.MAGENTA);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TranslateTransition heroMovement = new TranslateTransition();
        heroMovement.setNode(hero);
        heroMovement.setDuration(Duration.millis(600));
        heroMovement.setByY(200);
        heroMovement.setAutoReverse(true);
        heroMovement.setCycleCount(TranslateTransition.INDEFINITE);
        heroMovement.play();

        TranslateTransition greeOrcMovement = new TranslateTransition();
        greeOrcMovement.setNode(greenOrcs);
        greeOrcMovement.setDuration(Duration.millis(600));
        greeOrcMovement.setByY(200);
        greeOrcMovement.setAutoReverse(true);
        greeOrcMovement.setCycleCount(TranslateTransition.INDEFINITE);
        greeOrcMovement.play();

        TranslateTransition redOrcMovement = new TranslateTransition();
        redOrcMovement.setNode(redOrcs);
        redOrcMovement.setDuration(Duration.millis(600));
        redOrcMovement.setByY(200);
        redOrcMovement.setAutoReverse(true);
        redOrcMovement.setCycleCount(TranslateTransition.INDEFINITE);
        redOrcMovement.play();

        animation();
    }

    private void animation() {

        System.out.println(dy);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                (evt) -> {
                    hero.setY(dy);
                    if (hero.getLayoutBounds().intersects(myIsland411.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland511.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland5111.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland52111.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland521111.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland5211111.getLayoutBounds())){
                        dy = -dy;
                    }
                    if (hero.getLayoutBounds().intersects(myIsland5211.getLayoutBounds())){
                        dy = -dy;
                    }
                }
        ));

        timeline.setAutoReverse(true);
        timeline.setCycleCount(50);
        timeline.play();
}
    int background_cordinates = 0;
    int hero_cordinates = 0;

    public void screenMovement() {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(back_Group);
        translate.setDuration(Duration.millis(100));
        translate.setByX(-50);
        translate.play();

        TranslateTransition heroMovement = new TranslateTransition();
        heroMovement.setNode(hero);
        heroMovement.setDuration(Duration.millis(200));
        heroMovement.setByX(50);
        heroMovement.play();

        TranslateTransition moveButtonMovement = new TranslateTransition();
        moveButtonMovement.setNode(moveButton);
        moveButtonMovement.setByX(50);
        moveButtonMovement.play();
       }
}
*/

class cloudMovement{
    ImageView myImageCloud;
    public cloudMovement(ImageView myImageCloud){
        this.myImageCloud = myImageCloud;
        TranslateTransition translate = new TranslateTransition();
        translate.setNode((myImageCloud));
        translate.setDuration(Duration.millis(10000));
        translate.setByX(400);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }
}