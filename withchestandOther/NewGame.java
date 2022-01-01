package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static sample.constants.*;

public class NewGame implements Initializable {

    @FXML
    private Rectangle chest1;

    @FXML
    private Rectangle chest2;

    @FXML
    private ImageView cloud;

    @FXML
    private ImageView coin1;

    @FXML
    private ImageView coin10;

    @FXML
    private ImageView coin11;

    @FXML
    private ImageView coin12;

    @FXML
    private ImageView coin13;

    @FXML
    private ImageView coin14;

    @FXML
    private ImageView coin15;

    @FXML
    private ImageView coin16;

    @FXML
    private ImageView coin17;

    @FXML
    private ImageView coin18;

    @FXML
    private ImageView coin2;

    @FXML
    private ImageView coin3;

    @FXML
    private ImageView coin4;

    @FXML
    private ImageView coin5;

    @FXML
    private ImageView coin6;

    @FXML
    private ImageView coin7;

    @FXML
    private ImageView coin8;

    @FXML
    private ImageView coin9;

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
    private ImageView island1;

    @FXML
    private ImageView island10;

    @FXML
    private ImageView island11;

    @FXML
    private ImageView island12;

    @FXML
    private ImageView island13;

    @FXML
    private ImageView island14;

    @FXML
    private ImageView island15;

    @FXML
    private ImageView island16;

    @FXML
    private ImageView island17;

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
    private ImageView land1;

    @FXML
    private ImageView land2;

    @FXML
    private ImageView land3;

    @FXML
    private ImageView land4;

    @FXML
    private ImageView land5;

    @FXML
    private ImageView land6;

    @FXML
    private ImageView land7;

    @FXML
    private ImageView land8;

    @FXML
    private Button moveButton;

    @FXML
    private Label number_OfMoves;

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
    private ImageView redOrc5;

    @FXML
    private ImageView redOrc6;

    @FXML
    private ImageView tree1;

    @FXML
    private ImageView tree10;

    @FXML
    private ImageView tree11;

    @FXML
    private ImageView tree12;

    @FXML
    private ImageView tree13;

    @FXML
    private ImageView tree14;

    @FXML
    private ImageView tree15;

    @FXML
    private ImageView tree16;

    @FXML
    private ImageView tree17;

    @FXML
    private ImageView tree18;

    @FXML
    private ImageView tree19;

    @FXML
    private ImageView tree2;

    @FXML
    private ImageView tree20;

    @FXML
    private ImageView tree21;

    @FXML
    private ImageView tree22;

    @FXML
    private ImageView tree23;

    @FXML
    private ImageView tree24;

    @FXML
    private ImageView tree25;

    @FXML
    private ImageView tree26;

    @FXML
    private ImageView tree27;

    @FXML
    private ImageView tree3;

    @FXML
    private ImageView tree4;

    @FXML
    private ImageView tree5;

    @FXML
    private ImageView tree6;

    @FXML
    private ImageView tree7;

    @FXML
    private ImageView tree8;

    @FXML
    private ImageView tree9;
    
    private int heroPosX;
    private int heroPosY;

    int l1x,l1y,l2x,l2y,l3x,l3y,l4x,l4y,l5x,l5y,l6x,l6y,l7x,l7y;
    int l8x,l8y,l9x,l9y,l10x,l10y,l11x,l11y,l12x,l12y,l13x,l13y,l14x,l14y,l15x,l15y,l16x,l16y,l17x,l17y;

    int lu1x,lu2x,lu3x,lu4x,lu5x,lu6x,lu7x,lu8x;

    int ro1x,ro1y,ro2x,ro2y,ro3x,ro3y,ro4x,ro4y,ro5x,ro5y,ro6x,ro6y,ro7x,ro7y,ro8x,ro8y;
    int go1x,go1y,go2x,go2y,go3x,go3y,go4x,go4y,go5x,go5y,go6x,go6y,go7x,go7y,go8x,go8y;

    int t1x,t2x,t3x,t4x,t5x,t6x,t7x,t8x,t9x,t10x,t11x,t12x,t13x,t14x,t15x,t16x,t17x,t18x,t19x,t20x,t21x;
    int t22x,t23x,t24x,t25x,t26x,t27x;

    coinRotate coinRotate1,coinRotate2,coinRotate3,coinRotate4,coinRotate5,coinRotate6,coinRotate7,coinRotate8;
    coinRotate coinRotate9,coinRotate10,coinRotate11,coinRotate12,coinRotate13,coinRotate14,coinRotate15,coinRotate16,coinRotate17,coinRotate18;

    int c1x,c1y,c2x,c2y;

    redOrcMovement redOrcMovement1;
    redOrcMovement redOrcMovement2;
    redOrcMovement redOrcMovement3;
    redOrcMovement redOrcMovement4;
    redOrcMovement redOrcMovement5;
    redOrcMovement redOrcMovement6;

    greenOrcMovement greenOrcMovement1;
    greenOrcMovement greenOrcMovement2;
    greenOrcMovement greenOrcMovement3;
    greenOrcMovement greenOrcMovement4;
    greenOrcMovement greenOrcMovement5;

    int nOfMoves = 0;

    @FXML
    void screenMovement(ActionEvent event) {
        nOfMoves++;

        if (nOfMoves<4){
            hero.setX(heroPosX= heroPosX + 50);
        }

        number_OfMoves.setText("Location : " + nOfMoves);

        tree1.setX(t1x = t1x - 50);
        tree2.setX(t2x = t2x - 50);
        tree3.setX(t3x = t3x - 50);
        tree4.setX(t4x = t4x - 50);
        tree5.setX(t5x = t5x - 50);
        tree6.setX(t6x = t6x - 50);
        tree7.setX(t7x = t7x - 50);
        tree8.setX(t8x = t8x - 50);
        tree9.setX(t9x = t9x - 50);
        tree10.setX(t10x = t10x - 50);
        tree11.setX(t11x = t11x - 50);
        tree12.setX(t12x = t12x - 50);
        tree13.setX(t13x = t13x - 50);
        tree14.setX(t14x = t14x - 50);
        tree15.setX(t15x = t15x - 50);
        tree16.setX(t16x = t16x - 50);
        tree17.setX(t17x = t17x - 50);
        tree18.setX(t18x = t18x - 50);
        tree19.setX(t19x = t19x - 50);
        tree20.setX(t20x = t20x - 50);
        tree21.setX(t21x = t21x - 50);
        tree22.setX(t22x = t22x - 50);
        tree23.setX(t23x = t23x - 50);
        tree24.setX(t24x = t24x - 50);
        tree25.setX(t25x = t25x - 50);
        tree26.setX(t26x = t26x - 50);
        tree27.setX(t27x = t27x - 50);

        chest1.setX(c1x = c1x - 50);
        chest2.setX(c2x = c2x - 50);

        island1.setX(l1x = l1x - 50);
        island2.setX(l2x = l2x - 50);
        island3.setX(l3x = l3x - 50);
        island4.setX(l4x = l4x - 50);
        island5.setX(l5x = l5x - 50);
        island6.setX(l6x = l6x - 50);
        island7.setX(l7x = l7x - 50);
        island8.setX(l8x = l8x - 50);
        island9.setX(l9x = l9x - 50);
        island10.setX(l10x = l10x - 50);
        island11.setX(l11x = l11x - 50);
        island12.setX(l12x = l12x - 50);
        island13.setX(l13x = l13x - 50);
        island14.setX(l14x = l14x - 50);
        island15.setX(l15x = l15x - 50);
        island16.setX(l16x = l16x - 50);
        island17.setX(l17x = l17x - 50);


        greenOrc1.setX(go1x = go1x - 50);
        greenOrc2.setX(go2x = go2x - 50);
        greenOrc3.setX(go3x = go3x - 50);
        greenOrc4.setX(go4x = go4x - 50);
        greenOrc5.setX(go5x = go5x - 50);

        redOrc1.setX(ro1x = ro1x - 50);
        redOrc2.setX(ro2x = ro2x - 50);
        redOrc3.setX(ro3x = ro3x - 50);
        redOrc4.setX(ro4x = ro4x - 50);
        redOrc5.setX(ro5x = ro5x - 50);
        redOrc6.setX(ro6x = ro6x - 50);

        coinRotate1.moveButtonAction();
        coinRotate2.moveButtonAction();
        coinRotate3.moveButtonAction();
        coinRotate4.moveButtonAction();
        coinRotate5.moveButtonAction();
        coinRotate6.moveButtonAction();
        coinRotate7.moveButtonAction();
        coinRotate8.moveButtonAction();
        coinRotate9.moveButtonAction();
        coinRotate10.moveButtonAction();
        coinRotate11.moveButtonAction();
        coinRotate12.moveButtonAction();
        coinRotate13.moveButtonAction();
        coinRotate14.moveButtonAction();
        coinRotate15.moveButtonAction();
        coinRotate16.moveButtonAction();

    }

    Image chest;
    Image chestOpen;
    Paint chestOpenPaint;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cloudMovement cldMmt = new cloudMovement(cloud);

        chest = new Image("sample/assets/ChestClosed.png");
        Paint paint = new ImagePattern(chest);
        chest1.setFill(paint);
        chest2.setFill(paint);

        chestOpen = new Image("sample/assets/ChestOpen.png");
        chestOpenPaint = new ImagePattern(chestOpen);

        redOrcMovement1 = new redOrcMovement(redOrc1);
        redOrcMovement2 = new redOrcMovement(redOrc2);
        redOrcMovement3 = new redOrcMovement(redOrc3);
        redOrcMovement4 = new redOrcMovement(redOrc4);
        redOrcMovement5 = new redOrcMovement(redOrc5);
        redOrcMovement6 = new redOrcMovement(redOrc6);

        greenOrcMovement1 = new greenOrcMovement(greenOrc1);
        greenOrcMovement2 = new greenOrcMovement(greenOrc2);
        greenOrcMovement3 = new greenOrcMovement(greenOrc3);
        greenOrcMovement4 = new greenOrcMovement(greenOrc4);
        greenOrcMovement5 = new greenOrcMovement(greenOrc5);

        coinRotate1 = new coinRotate(coin1);
        coinRotate2 = new coinRotate(coin2);
        coinRotate3 = new coinRotate(coin3);
        coinRotate4 = new coinRotate(coin4);
        coinRotate5 = new coinRotate(coin5);
        coinRotate6 = new coinRotate(coin6);
        coinRotate7 = new coinRotate(coin7);
        coinRotate8 = new coinRotate(coin8);
        coinRotate9 = new coinRotate(coin9);
        coinRotate10 = new coinRotate(coin10);
        coinRotate11 = new coinRotate(coin11);
        coinRotate12 = new coinRotate(coin12);
        coinRotate13 = new coinRotate(coin13);
        coinRotate14 = new coinRotate(coin14);
        coinRotate15 = new coinRotate(coin15);
        coinRotate16 = new coinRotate(coin16);
        coinRotate17 = new coinRotate(coin17);
        coinRotate18 = new coinRotate(coin18);

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

                    if (hero.getBoundsInParent().intersects(chest1.getBoundsInParent())){
                        chest1.setFill(chestOpenPaint);
                    }
                    else if (hero.getBoundsInParent().intersects(chest2.getBoundsInParent())){
                        chest2.setFill(chestOpenPaint);
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
                    else if (hero.getBoundsInParent().intersects(island15.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island16.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island17.getBoundsInParent())) {
                        dy = -dy;
                    }

                }
        ));
        n++;
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}

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

    public void moveButtonAction(){
        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(image);
        translate5.setDuration(Duration.millis(100));
        translate5.setByX(-50);
        translate5.play();
    }

}

class greenOrcMovement{
    ImageView greenOrc;
    public greenOrcMovement(ImageView greenOrc){
        this.greenOrc = greenOrc;
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(greenOrc);
        transition.setDuration(Duration.millis(600));
        transition.setByY(-139);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }
    public void moveButtonAction(){
        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(greenOrc);
        translate5.setDuration(Duration.millis(100));
        translate5.setByX(-50);
        translate5.play();
    }
}

class redOrcMovement{
    ImageView redOrc;
    public redOrcMovement(ImageView redOrc){
        this.redOrc = redOrc;
        TranslateTransition transition2 = new TranslateTransition();
        transition2.setNode(redOrc);
        transition2.setDuration(Duration.millis(600));
        transition2.setByY(99);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.play();
    }

    public void moveButtonAction(){
        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(redOrc);
        translate5.setDuration(Duration.millis(100));
        translate5.setByX(-50);
        translate5.play();
    }
}