package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
    private Rectangle chest3;

    @FXML
    private Rectangle tntBlast1;

    @FXML
    private Rectangle tntBlast2;

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
    private ImageView coin19;

    @FXML
    private ImageView coin20;

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
    private ImageView island20;

    @FXML
    private ImageView island19;

    @FXML
    private ImageView island18;

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
    private ImageView orc;

    @FXML
    private ImageView land8;

    @FXML
    private Button moveButton;

    @FXML
    private Button pauseResume;

    @FXML
    private Label number_OfMoves;

    @FXML
    private Label coinsLabel;

    @FXML
    private AnchorPane pane;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Rectangle tnt1;

    @FXML
    private Rectangle tnt2;

    @FXML
    private Rectangle chestCoin;

    @FXML
    private Rectangle chestWeapon;

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
    private ImageView coin21;

    @FXML
    private ImageView coin22;

    @FXML
    private ImageView coin23;

    @FXML
    private ImageView coin24;

    @FXML
    private ImageView coin25;

    @FXML
    private ImageView tree2;

    @FXML
    private ImageView tree20;

    @FXML
    private ImageView tree21;

    @FXML
    private ImageView tree22;

    @FXML
    private ImageView cloud2;

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
    private ImageView home;

    @FXML
    private ImageView tree5;

    @FXML
    private ImageView tree6;

    @FXML
    private ImageView tree7;

    @FXML
    private ImageView tree8;

    @FXML
    private ImageView myAxe;

    @FXML
    private ImageView tree9;

    private int heroPosX;
    private int heroPosY;

    int l1x,l1y,l2x,l2y,l3x,l3y,l4x,l4y,l5x,l5y,l6x,l6y,l7x,l7y;
    int l8x,l8y,l9x,l9y,l10x,l10y,l11x,l11y,l12x,l12y,l13x,l13y,l14x,l14y,l15x,l15y,l16x,l16y,l17x,l17y;
    int l18x,l18y,l19x,l19y,l20x,l20y;

    int lu1x,lu2x,lu3x,lu4x,lu5x,lu6x,lu7x,lu8x;

    int ro1x,ro1y,ro2x,ro2y,ro3x,ro3y,ro4x,ro4y,ro5x,ro5y,ro6x,ro6y,ro7x,ro7y,ro8x,ro8y;
    int go1x,go1y,go2x,go2y,go3x,go3y,go4x,go4y,go5x,go5y,go6x,go6y,go7x,go7y,go8x,go8y;

    int t1x,t2x,t3x,t4x,t5x,t6x,t7x,t8x,t9x,t10x,t11x,t12x,t13x,t14x,t15x,t16x,t17x,t18x,t19x,t20x,t21x;
    int t22x,t23x,t24x,t25x,t26x,t27x;

    int la1,la2,la3,la4,la5,la6,la7,la8;

    int h1x;

    int Axe1x;

    int ox,oy;

    coinRotate coinRotate1,coinRotate2,coinRotate3,coinRotate4,coinRotate5,coinRotate6,coinRotate7,coinRotate8,coinRotate19,coinRotate20;
    coinRotate coinRotate9,coinRotate10,coinRotate11,coinRotate12,coinRotate13,coinRotate14,coinRotate15,coinRotate16,coinRotate17,coinRotate18;

    int c1x,c1y,c2x,c2y,c3x,c3y;

    int ci1,ci2,ci3,ci4,ci5;

    int coins;

    int tnt1x,tnt2x;

    int bst1,bst2;

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
    greenOrcMovement orcMovement;

    int nOfMoves = 0;

    boolean pause = false;

    int pausecounter=0;

    @FXML
    void pauseOrResumeGame(ActionEvent event){
        pausecounter++;
        if (pausecounter%2 != 0){
            pause = true;

            redOrcMovement1.stp();
            redOrcMovement2.stp();
            redOrcMovement3.stp();
            redOrcMovement4.stp();
            redOrcMovement5.stp();
            redOrcMovement6.stp();

            greenOrcMovement1.stp();
            greenOrcMovement2.stp();
            greenOrcMovement3.stp();
            greenOrcMovement4.stp();
            greenOrcMovement5.stp();

            cldMmt.stp();

            coinRotate1.stp();
            coinRotate2.stp();
            coinRotate3.stp();
            coinRotate4.stp();
            coinRotate5.stp();
            coinRotate6.stp();
            coinRotate7.stp();
            coinRotate8.stp();
            coinRotate9.stp();
            coinRotate10.stp();
            coinRotate11.stp();
            coinRotate12.stp();
            coinRotate13.stp();
            coinRotate14.stp();
            coinRotate15.stp();
            coinRotate16.stp();
            coinRotate17.stp();
            coinRotate18.stp();
            coinRotate19.stp();
            coinRotate20.stp();

            dy = 0;
        }
        else{
            dy = 4;

            redOrcMovement1.ply();
            redOrcMovement2.ply();
            redOrcMovement3.ply();
            redOrcMovement4.ply();
            redOrcMovement5.ply();
            redOrcMovement6.ply();

            greenOrcMovement1.ply();
            greenOrcMovement2.ply();
            greenOrcMovement3.ply();
            greenOrcMovement4.ply();
            greenOrcMovement5.ply();

            cldMmt.ply();

            coinRotate1.ply();
            coinRotate2.ply();
            coinRotate3.ply();
            coinRotate4.ply();
            coinRotate5.ply();
            coinRotate6.ply();
            coinRotate7.ply();
            coinRotate8.ply();
            coinRotate9.ply();
            coinRotate10.ply();
            coinRotate11.ply();
            coinRotate12.ply();
            coinRotate13.ply();
            coinRotate14.ply();
            coinRotate15.ply();
            coinRotate16.ply();
            coinRotate17.ply();
            coinRotate18.ply();
            coinRotate19.ply();
            coinRotate20.ply();
        }
    }

    @FXML
    void screenMovement(ActionEvent event) {
        nOfMoves++;

        if (nOfMoves<4){
            hero.setX(heroPosX = heroPosX + 20);
        }

        number_OfMoves.setText("Steps : " + nOfMoves);

        land1.setX(la1 = la1 - 50);
        land2.setX(la2 = la2 - 50);
        land3.setX(la3 = la3 - 50);
        land4.setX(la4 = la4 - 50);
        land5.setX(la5 = la5 - 50);
        land6.setX(la6 = la6 - 50);
        land7.setX(la7 = la7 - 50);
        land8.setX(la8 = la8 - 50);

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

        coin21.setX(ci1 = ci1 - 50);
        coin22.setX(ci2 = ci2 - 50);
        coin23.setX(ci3 = ci3 - 50);
        coin24.setX(ci4 = ci4 - 50);
        coin25.setX(ci5 = ci5 - 50);

        tnt1.setX(tnt1x = tnt1x - 50);
        tnt2.setX(tnt2x = tnt2x - 50);

        chest1.setX(c1x = c1x - 50);
        chest2.setX(c2x = c2x - 50);
        chest3.setX(c3x = c3x - 50);

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
        island18.setX(l18x = l18x - 50);
        island19.setX(l19x = l19x - 50);
        island20.setX(l20x = l20x - 50);

        greenOrc1.setX(go1x = go1x - 50);
        greenOrc2.setX(go2x = go2x - 50);
        greenOrc3.setX(go3x = go3x - 50);
        greenOrc4.setX(go4x = go4x - 50);
        greenOrc5.setX(go5x = go5x - 50);

        orc.setX(ox = ox -50);

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
        coinRotate17.moveButtonAction();
        coinRotate18.moveButtonAction();
        coinRotate19.moveButtonAction();
        coinRotate20.moveButtonAction();

        if (temp== 0) {
            myAxe.setX(Axe1x = Axe1x - 50);
        }
    }

    Image chest;
    Image chestOpen;
    Paint chestOpenPaint;
    Image tnt;
    Image blastImg;
    Paint blastImgPaint;
    cloudMovement cldMmt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cldMmt = new cloudMovement(cloud);

        coin21.setOpacity(0);
        coin22.setOpacity(0);
        coin23.setOpacity(0);
        coin24.setOpacity(0);
        coin25.setOpacity(0);

        myAxe.setOpacity(0);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(myAxe);
        rotateTransition.setDuration(Duration.millis(700));
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setByAngle(150);
        rotateTransition.play();

        chest = new Image("sample/assets/ChestClosed.png");
        Paint paint = new ImagePattern(chest);
        chest1.setFill(paint);
        chest2.setFill(paint);
        chest3.setFill(paint);

        tnt = new Image("sample/assets/TNT.png");
        Paint p = new ImagePattern(tnt);
        tnt1.setFill(p);
        tnt2.setFill(p);
        chestOpen = new Image("sample/assets/ChestOpen.png");
        chestOpenPaint = new ImagePattern(chestOpen);

        blastImg = new Image("sample/assets/blast.jpg");
        blastImgPaint = new ImagePattern(blastImg);

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
        orcMovement  = new greenOrcMovement(orc);

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
        coinRotate19 = new coinRotate(coin19);
        coinRotate20 = new coinRotate(coin20);

        collision();
    }

    private int dy = 4;
    private double time = 40;
    private int n = 0;
    private int dy1 = 4;

    int temp =0;

    private void collision() {

        if (n>0){
            time = time * 2;
        }

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(time),
                (evt) -> {

                    hero.setY(hero.getY() + dy);

                    if (temp!= 0) {
                        myAxe.setY(myAxe.getY() + dy1);
                        if (myAxe.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
                            dy1 = -dy1;
                        }
                        if (myAxe.getBoundsInParent().intersects(island20.getBoundsInParent())){
                            dy1 = -dy1;
                        }
                        else if(myAxe.getBoundsInParent().intersects(island17.getBoundsInParent())){
                            dy1 = -dy1;
                        }
                        else if(myAxe.getBoundsInParent().intersects(island18.getBoundsInParent())){
                            dy1 = -dy1;
                        }
                    }

                    if (hero.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
                        dy = -dy;
                    }

                    if (hero.getBoundsInParent().intersects(redOrc1.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc1);
                    }
                    else if (hero.getBoundsInParent().intersects(redOrc2.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc2);
                    }
                    else if (hero.getBoundsInParent().intersects(redOrc3.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc3);
                    }
                    else if (hero.getBoundsInParent().intersects(redOrc4.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc4);
                    }
                    else if (hero.getBoundsInParent().intersects(redOrc5.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc5);
                    }
                    else if (hero.getBoundsInParent().intersects(redOrc6.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(redOrc6);
                    }
                    else if (hero.getBoundsInParent().intersects(orc.getBoundsInParent())){
                        coins = coins + 10;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(orc);
                    }


                    if (hero.getBoundsInParent().intersects(coin1.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin1);
                    }
                    else if (hero.getBoundsInParent().intersects(coin2.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin2);
                    }
                    else if (hero.getBoundsInParent().intersects(coin3.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin3);
                    }
                    else if (hero.getBoundsInParent().intersects(coin4.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin4);
                    }
                    else if (hero.getBoundsInParent().intersects(coin5.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin5);
                    }
                    else if (hero.getBoundsInParent().intersects(coin6.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin6);
                    }
                    else if (hero.getBoundsInParent().intersects(coin7.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin7);
                    }
                    else if (hero.getBoundsInParent().intersects(coin8.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin8);
                    }
                    else if (hero.getBoundsInParent().intersects(coin9.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin9);
                    }
                    else if (hero.getBoundsInParent().intersects(coin10.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin10);
                    }
                    else if (hero.getBoundsInParent().intersects(coin11.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin11);
                    }
                    else if (hero.getBoundsInParent().intersects(coin12.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin12);
                    }
                    else if (hero.getBoundsInParent().intersects(coin13.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin13);
                    }
                    else if (hero.getBoundsInParent().intersects(coin14.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin14);
                    }
                    else if (hero.getBoundsInParent().intersects(coin15.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin15);
                    }
                    else if (hero.getBoundsInParent().intersects(coin16.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin16);
                    }
                    else if (hero.getBoundsInParent().intersects(coin17.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin17);
                    }
                    else if (hero.getBoundsInParent().intersects(coin18.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin18);
                    }
                    else if (hero.getBoundsInParent().intersects(coin19.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin19);
                    }
                    else if (hero.getBoundsInParent().intersects(coin20.getBoundsInParent())){
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killCoin(coin20);
                    }

                    if (hero.getBoundsInParent().intersects(greenOrc1.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(greenOrc1);
                    }
                    else if (hero.getBoundsInParent().intersects(greenOrc2.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(greenOrc2);
                    }
                    else if (hero.getBoundsInParent().intersects(greenOrc3.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(greenOrc3);
                    }
                    else if (hero.getBoundsInParent().intersects(greenOrc4.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(greenOrc4);
                    }
                    else if (hero.getBoundsInParent().intersects(greenOrc5.getBoundsInParent())){
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        killredOrc(greenOrc5);
                    }

                    if (hero.getBoundsInParent().intersects(chest1.getBoundsInParent())){
                        coins++;
                        coins++;
                        chest1.setFill(chestOpenPaint);
                        coinsLabel.setText("Coins " + coins);
                        coin24.setOpacity(1);
                        coin25.setOpacity(1);
                        coin24.setOpacity(0.5);
                        coin25.setOpacity(0.5);
                    }
                    else if (hero.getBoundsInParent().intersects(chest2.getBoundsInParent())){

                        chest2.setFill(chestOpenPaint);
                        myAxe.setOpacity(1);
                        temp = 1;
                    }
                    else if (hero.getBoundsInParent().intersects(chest3.getBoundsInParent())){
                        coins++;
                        coins++;
                        coins++;
                        coinsLabel.setText("Coins " + coins);
                        chest3.setFill(chestOpenPaint);
                        coin21.setOpacity(1);
                        coin22.setOpacity(1);
                        coin23.setOpacity(1);

                        coin21.setOpacity(0.5);
                        coin22.setOpacity(0.5);
                        coin23.setOpacity(0.5);


                    }

                    if (hero.getBoundsInParent().intersects(tnt1.getBoundsInParent())){
                        tnt1.setFill(blastImgPaint);
                        tnt1.setScaleX(4);
                        tnt1.setScaleY(4);
                        if (endgamecounter == 0) endGame();
                        if (endgamecounter == 1) endGame();
                    }
                    else if (hero.getBoundsInParent().intersects(tnt2.getBoundsInParent())){
                        tnt2.setFill(blastImgPaint);
                        tnt2.setScaleX(4);
                        tnt2.setScaleY(4);
                        if (endgamecounter == 0) endGame();

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
                    else if (hero.getBoundsInParent().intersects(island18.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island19.getBoundsInParent())) {
                        dy = -dy;
                    }
                    else if (hero.getBoundsInParent().intersects(island20.getBoundsInParent())) {
                        dy = -dy;
                    }
                }
        ));
        n++;
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void killCoin(ImageView img){
        TranslateTransition t = new TranslateTransition();
        t.setNode(img);
        t.setByX(500);
        t.setByY(700);
        t.setDuration(Duration.millis(10));
        t.play();
        img.setOpacity(0.5);
    }

    int endgamecounter = 0;

    private void killredOrc(ImageView img){
        TranslateTransition t = new TranslateTransition();
        t.setNode(img);
        t.setByX(500);
        t.setByY(700);
        t.setDuration(Duration.millis(10));
        t.play();
        img.setOpacity(0);
    }
    
    public void endGame(){
        endgamecounter++;
        Label l;
        if (endgamecounter == 2){
            l = new Label("You have " + coins + "coins. You are not eligible for resume game. Do you want to save the game and return to main menu?");
            WillheroAleartBox a = new WillheroAleartBox();
            a.display(l,false);
            return;
        }

        if (coins > 100){
            l = new Label("You have " + coins + "coins. Do you want to use the coins and continue the game? ");
            WillheroAleartBox a = new WillheroAleartBox();
            a.display(l,true);
        }
        else{
            l = new Label("You have " + coins + "coins. You are not eligible for resume game. Do you want to save the game and return to main menu?");
            WillheroAleartBox a = new WillheroAleartBox();
            a.display(l,false);
        }
    }

    public void switchToSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.show();
    }
}

class cloudMovement{
    ImageView myImageCloud;
    TranslateTransition translate;
    public cloudMovement(ImageView myImageCloud){
        this.myImageCloud = myImageCloud;
        translate = new TranslateTransition();
        translate.setNode((myImageCloud));
        translate.setDuration(Duration.millis(10000));
        translate.setByX(400);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }
    public void stp(){
        translate.stop();
    }
    public void ply(){
        translate.play();
    }
}

class coinRotate{

    ImageView image;
    RotateTransition transition1;
    public coinRotate(ImageView img){
        this.image = img;
        transition1 = new RotateTransition();
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
    public void stp(){
        transition1.stop();
    }
    public void ply(){
        transition1.play();
    }

}

class greenOrcMovement{
    ImageView greenOrc;
    TranslateTransition transition;
    double y;

    public greenOrcMovement(ImageView greenOrc){
        this.greenOrc = greenOrc;
        y = greenOrc.getLayoutY();
        transition = new TranslateTransition();
        transition.setNode(greenOrc);
        transition.setDuration(Duration.millis(700));
        transition.setByY(-130);
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
    public void stp(){
        transition.stop();
    }
    public void ply(){
        transition.play();
    }
}

class redOrcMovement{
    ImageView redOrc;
    TranslateTransition transition2;
    double y;
    public redOrcMovement(ImageView redOrc){
        this.redOrc = redOrc;
        y = redOrc.getY();
        transition2 = new TranslateTransition();
        transition2.setNode(redOrc);
        transition2.setDuration(Duration.millis(700));
        transition2.setByY(90);
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
    public void stp(){
        transition2.stop();
    }
    public void ply(){
        redOrc.setY(-y);
        transition2.play();
    }
}