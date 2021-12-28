/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;


/**
 *
 * @author imyat
 */

//Creature Class with its sub-classes

abstract class Creature{
    private int hp;
    private String location;
    Creature(int hp, String location){
        this.hp = hp;
        this.location = location;
    }
    
    public void setHP(int hp){
        this.hp = hp;
    }
    
    public int getHP(){
        return hp;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public String getLocation(){
        return location;
    }
}


// Plants with its sub-classes


abstract class Plants extends Creature{
    private int attack, sunCost, level;
    private long time;
    private ArrayList<Integer> posX = new ArrayList<>();
    private ArrayList<Integer> posY = new ArrayList<>();
    
    Plants(int level, int hp, String location, int sunCost, int attack, long time){
        super(hp, location);
        this.level = level;
        this.sunCost = sunCost;
        this.attack = attack;
        this.time = time;
    }
    
    public int getSunCost() {
        return sunCost;
    }

    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public ArrayList getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX.add(posX);
    }

    public ArrayList getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY.add(posY);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}



// Barrier with its subcalss


abstract class Barrier extends Plants{
    
    Barrier(int level, int hp, String location, int sunCost, int attack, long time){
        super(level, hp ,location, sunCost, 0, time);
    }
}


class Wallnut extends Barrier{
    
    Wallnut(){
        super(5, 4000, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Walnut.PNG", 50, 0, 20);
    }
}




// Bomb with its subclass


abstract class Bomb extends Plants{
    
    private int affectedGrid; //Only odd and the area affected should be equals -> (int)affectedGrid/2, in all the four directions
    Bomb(int level, int hp, String location, int sunCost, int attack, int affectedGrid, long time){
        super(level, 0, location, sunCost, attack, time);
    }
}


class CherryBomb extends Bomb{
    
    CherryBomb(){
        super(4, 300, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/CherryBomb.PNG", 50, 1800, 3, 20);
    }
}


class PotatoMine extends Bomb{
    
    PotatoMine(){
        super(3, 300, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PotatoMine.PNG", 25, 1800, 1, 5);
    }
}



// Shooter with its subclass


abstract class Shooter extends Plants{
    
    Shooter(int level, int hp, String location, int sunCost, int attack, long time){
        super(level, hp, location, sunCost, attack, time);
    }
    
    public void peaTransition(Pane pane, String location, int layoutX, int layoutY, int endPos)throws IOException {
    	
    	FileInputStream fis = new FileInputStream(location);
    	Image image = new Image(fis);
    	ImageView iv = new ImageView(image);
    	iv.setLayoutX(layoutX);
    	iv.setLayoutY(layoutY);
    	
    	TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(3));
    	transition.setToX(endPos);
    	transition.setNode(iv);
    	transition.play();
    }
    
}


class PeaShooter extends Shooter{
    
    PeaShooter(){
        super(1, 300, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PeaShooter.PNG", 100, 20, 5);
    }
}



// SunProducer with its subclass


abstract class SunProducer extends Plants{
    
    SunProducer(int level, int hp, String location, int sunCost, int attack, long time){
        super(level, hp, location, sunCost, 0, time);
    }
}


class SunFlower extends SunProducer{
    
    SunFlower(){
        super(2, 300, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/SunFlower.PNG", 50, 0, 5);
    }
}



////////////////////////////////////////////////////////////////////////    PLANTS END


//Zombies with its subclasses



class Zombies extends Creature{
    private int posX, posY, attack;
    Zombies(int hp, String location){
        super(hp, location);
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public void addZombieGIF(Pane pane)throws IOException {
    	FileInputStream fis = new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Zombies.GIF");
        Image image = new Image(fis);
        ImageView iv = new ImageView(image);
        System.out.println("IN ZOMBIES");
        pane.getChildren().add(iv);
    }
    
}




/////////////////////////////////////////////////////////////////////////   ZOMBIES END





//Sun Class


class Sun{
	
	private ImageView iv;
	private String location = "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Sun.PNG";
	private int startPosX, startPosY, posY, posX;
	private Pane pane;
	private int value = 50;
	
	Sun(Pane pane, int startPosX, int startPosY){
		this.posX = startPosX;
		this.posY = startPosY;
		this.pane = pane;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setImageView(ImageView iv) {
		this.iv = iv;
	}
	
	public ImageView getImageView() {
		return iv;
	}
	
	public ImageView getImage()throws IOException {
		ImageView iv = new ImageView(new Image(new FileInputStream(location)));
		this.setImageView(iv);
		return iv;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosX() {
		int posX = (int)(Math.random() * 400) + 60;
		return posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void addToPane() throws IOException {
		iv = this.getImage();
		Label label = new Label();
		iv.setLayoutX(this.getPosX());
		iv.setLayoutY(this.getPosY());
		iv.setFitHeight(50);
		iv.setFitWidth(50);
		this.setPosY(this.getPosY() + 5);
		
		iv.setOnMouseClicked(e -> {
			this.removeImage(iv);
		});
		
		pane.getChildren().add(iv);
	}
	
	public void removeImage(ImageView iv) {
		pane.getChildren().remove(iv);
		System.out.println("R");
	}
}


// TopBar Class


class Bar{
    
    private int level, posX, posY, width, height;
    private Label[] levels;
    private Plants[] plants;
    private Pane pane;
    private Plants plantType;
    private static int storePlantIndex;
    private Label label;
    //Bar(pane, totalLevels, starting x-coordinate, starting y-coordinate, image width, image height)
    Bar(Pane pane, int totalLevels, int currentLevel, int posX, int posY, int width, int height){
        this.pane = pane;
        this.level = currentLevel;
        levels = new Label[totalLevels];
        plants = new Plants[totalLevels];
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        initializePlants();
    }
    
    
    public Label createImageLabel(String text,String imageLocation, int width, int height)throws IOException{
        ImageView imageView = importImage(imageLocation);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        Label label = new Label(text, imageView);
        return label;
    }
    
    public ImageView importImage(String imageLocation)throws IOException{
        FileInputStream fis = new FileInputStream(imageLocation);
        Image image = new Image(fis);
        ImageView imageView = new ImageView(image);
        fis.close();
        return imageView;
    }
    
    
    public void initializePlants(){
        plants[0] = new PeaShooter();
        plants[1] = new SunFlower();
        plants[2] = new PotatoMine();
        plants[3] = new CherryBomb();
        plants[4] = new Wallnut();
    }
    
    public void setPlantType(Plants plant){
        plantType = plant;
    }
    
    public Plants getPlantType(){
        return plantType;
    }
    
    public void setLabel(Label label) {
    	this.label = label;
    }
    
    public Label getLabel() {
    	return label;
    }
    
    public void createBar() throws IOException{
        Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/TopLeftBar.PNG", 500, 100);
        Label label2 = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Sun.PNG", width, height);
        label.setLayoutX(0);
        label.setLayoutY(0);
        pane.getChildren().add(label);
        label2.setLayoutX(posX);
        label2.setLayoutY(posY);
        pane.getChildren().add(label2);
        Label label3 = new Label();
        label3.setLayoutX(posX + 10);
        label3.setLayoutY(posY + height + 5);
        label3.setText("00");
        pane.getChildren().add(label3);
        posX = posX + width + 10;
        for(int i=0; i<this.level; i++){
            levels[i] = createImageLabel("", plants[i].getLocation(), width, height);
            levels[i].setLayoutX(posX);
            levels[i].setLayoutY(posY);
            pane.getChildren().add(levels[i]);
            Label label1 = levels[i];
            int pos = i;
            label1.setOnMouseClicked(e -> {
               this.setPlantType(plants[pos]);
               System.out.println("LOCATION, STORE INDEX -> " + this.getPlantType().getLocation() + ", " + pos);
            });
            posX = posX + width + 10;
        }
        posX = posX + 10;
        Button saveButton = new Button("SAVE");
        saveButton.setLayoutX(posX);
        saveButton.setLayoutY(posY + 20);
        pane.getChildren().add(saveButton);
        
        posX = posX + width + 10;
        
        Button menuButton = new Button("MENU");
        menuButton.setLayoutX(posX);
        menuButton.setLayoutY(posY + 20);
        
        /*menuButton.setOnAction(e -> {
            PlantsVSZombies pvz = new PlantsVSZombies();
            try {
                pvz.main({"a","b"});
            } catch (IOException ex) {
                Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        pane.getChildren().add(menuButton);
        //return getPlantType();
    }
    
    
}




final class Lawn{
    
    private int rows, columns, width, height, x, y, xStart;
    private Rectangle[][] rectangle;
    private Pane pane;
    private ArrayList<Integer> xAxis = new ArrayList<>(), yAxis = new ArrayList<>();
    public Lawn(int rows, int columns, int x, int y, int width, int height, Pane pane){
        this.x = x;
        this.y = y;
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
        this.pane = pane;
        setX(x);
        setY(y);
        setRows(rows);
        setColumns(columns);
        setRectangleWidth(width);
        setRectangleHeight(height);
        createLawn();
        setUpLawn(pane);
    }
    
    public void setX(int x){
        this.x = x;
        xStart = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setRows(int rows){
        this.rows = rows; 
    }
    
    public void setColumns(int columns){
        this.columns = columns;
    }
    
    public int getRows(){
        return rows;
    }
    
    public int getColumns(){
        return columns;
    }
    
    public void setRectangleWidth(int width){
        this.width = width;
    }
    
    public void setRectangleHeight(int height){
        this.height = height;
    }
    
    public void createLawn(){
        rectangle = new Rectangle[rows][columns];
    }
    
    public void addXCor(int x){
        this.xAxis.add(x);
    }
    
    public void addYCor(int y){
        this.yAxis.add(y);
    }
    
    public ArrayList xAxis(){
        return this.xAxis;
    }
    
    public ArrayList yAxis(){
        return this.yAxis;
    }
    
    
    public void setUpLawn(Pane pane){
        String darkGridLocation = "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/DarkGridImage.png";
        String lightGridLocation = "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/LightGridImage1.png";
        Lawnmower mower = new Lawnmower();
        Image image1 = null, image2 = null;
        try{
            FileInputStream fis1 = new FileInputStream(darkGridLocation);
            FileInputStream fis2 = new FileInputStream(lightGridLocation);
            image1 = new Image(fis1);
            image2 = new Image(fis2);
        }
        catch(Exception ex){
            
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                rectangle[i][j] = new Rectangle(x,y,width,height);
                if((i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0)){
                    rectangle[i][j].setFill(new ImagePattern(image2));
                }
                else{
                    rectangle[i][j].setFill(new ImagePattern(image1));
                }
                if(i%2 == 0 && j == 2){
                    try{
                        FileInputStream fis = new FileInputStream(mower.getLocation());
                        Image image = new Image(fis);
                        rectangle[i][j].setFill(new ImagePattern(image));
                    }
                    catch(Exception ex){

                    }
                }
                pane.getChildren().add(rectangle[i][j]);
                x += width;
            }
            x = xStart;
            y += height;
        }
    }
    
    public Rectangle[][] getRectangle(){
        return rectangle;
    }
    
    public Pane getLawnPane(){
        return pane;
    }
    
    
}



class Lawnmower{
    
    ArrayList<Integer> posX = new ArrayList<>();
    ArrayList<Integer> posY = new ArrayList<>();
    
    String location = "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Lawnmower.png";
    
    
    public void setPosX(int x){
        posX.add(x);
    }
    
    public void setPosY(int y){
        posY.add(y);
    }
    
    public ArrayList getPosX(){
        return posX;
    }
    
    public ArrayList getPosY(){
        return posY;
    }
    
    public String getLocation(){
        return location;
    }
    
    
}





class PlayerProfile implements Serializable{
    
    String playerName;
    ArrayList<String> playerNameList = new ArrayList<>();
    public void setPlayerName(String name){
        playerName = name;
        playerNameList.add(name);
    }
    
    public ArrayList getPlayerNameList(){
        return playerNameList;
    }
}






public class PlantsVSZombies extends Application {
    
    Timeline timeline;
	Sun sun;
    PlayerProfile profile = new PlayerProfile();
    
    Stage window;
    Label menuBackground;
    Scene menuBackgroundScene;
    Lawn lawn;
    Bar bar;
    
    static int rectRows = 0;
    static int rectColumns = 0;
    
    ArrayList<String> playerNameList = new ArrayList<>();
    ArrayList<Integer> rectXCor = new ArrayList<>();
    ArrayList<Integer> rectYCor = new ArrayList<>();
    ArrayList<Plants> plantList = new ArrayList<>();
    
    String[] location = {"D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Sun.PNG", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PeaShooter.GIF", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/SunFLower.PNG","D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/CherryBomb.PNG","D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Walnut.PNG", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/SnowPea.PNG"};    
    
    public Button createButton(String btnTitle, double xCoordinate, double yCoordinate){
        Button btn = new Button(btnTitle);
        btn.setMaxSize(300, 300);
        btn.setLayoutX(xCoordinate);
        btn.setLayoutY(yCoordinate);
        return btn;
    }    
    
    public Button createImageButton(String btnTitle, String imageLocation, double xCoordinate, double yCoordinate)throws IOException{
        ImageView imageView = importImage(imageLocation);
        Button btn = new Button(btnTitle, imageView);
        btn.setMaxSize(300, 300);
        btn.setLayoutX(xCoordinate);
        btn.setLayoutY(yCoordinate);
        return btn;
    }
    
    
    public Pane createPane(Pane ...allPane){
        Pane pane = new Pane();
        for(Pane i : allPane){
            pane.getChildren().add(i);
        }
        return pane;
    }
    
    public Label createTextLabel(String text, double xCoordinate, double yCoordinate){
        Label label = new Label(text);
        label.setLayoutX(xCoordinate);
        label.setLayoutY(yCoordinate);
        return label;
    }
    
    public Label createImageLabel(String text, String imageLocation, int width, int height)throws IOException{
        ImageView imageView = importImage(imageLocation);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        Label label = new Label(text, imageView);
        return label;
    }
    
    public ImageView importImage(String imageLocation)throws IOException{
        FileInputStream fis = new FileInputStream(imageLocation);
        Image image = new Image(fis);
        ImageView imageView = new ImageView(image);
        fis.close();
        return imageView;
    }
    
    public TextField createTextField(double xCoordinate, double yCoordinate){
        TextField textField = new TextField();
        textField.setLayoutX(xCoordinate);
        textField.setLayoutY(yCoordinate);
        return textField;
    }
    
    public Scene createScene(Pane pane, int length, int width){
        Scene scene = new Scene(pane, length, width);
        return scene;
    }
    
    public Stage createStage(Stage stage, Scene scene, String title){
        stage.setTitle(title);
        stage.setScene(scene);
        return stage;
    }
    
    /*
    public void addLabelToTopLeftBar(Pane pane, int level)throws IOException{
        Label[] label = new Label[level + 1];
        int xCor = 10;
        int yCor = 10;
        for(int i=0; i<label.length; i++){
            label[i] = createImageLabel("", location[i], 50, 55);
            label[i].setLayoutX(xCor);
            label[i].setLayoutY(yCor);
            
            xCor += 60;
            addToPane(pane, label[i]);
        }
        
        /*for(int i=0; i<label.length; i++){
            label[i].setOnMouseClicked(e -> {
                storeImageLocation[0] = location[i];
            });break;
        }
    }
    
    public Pane createTopLeftBar()throws IOException{
        Pane pane = createPane();
        Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/TopLeftBar.PNG", 500, 100);
        label.setLayoutX(0);
        label.setLayoutY(0);
        addToPane(pane, label);
        addLabelToTopLeftBar(pane, 5);
        return pane;
    }*/
    
    
    public Bar createTopLeftBar(Pane pane, int totalLevel, int currentLevel)throws IOException{
        bar = new Bar(pane, totalLevel, currentLevel, 10, 10, 50, 50);
        bar.createBar();
        return bar;
    }
    
    
    
    public void printValue(double x,double y){
        System.out.println((int)x/50 + " " + (int)y/50);
    }
    
    
    public Pane createLawn(int rows, int columns, int x, int y, int width, int height)throws IOException{
        int col = 9;
        int row = 3;
        Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/LawnImage.PNG", 500, 500);
        Label houseLabel = this.createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/House.PNG", 100, 500);
        houseLabel.setLayoutY(100);
        Pane pane = createPane();
        addToPane(pane, label);
        lawn = new Lawn(rows, columns, x, y, width, height, pane);
        pane = lawn.getLawnPane();//addToPane(pane, label);
        addToPane(pane, houseLabel);
        Rectangle[][] rectangle = lawn.getRectangle();
        
        FileInputStream fis1 = new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/SnowPea.PNG");
        Image image1 = new Image(fis1);
        rectangle[4][4].setFill(new ImagePattern(image1));
        
        Bar bar = createTopLeftBar(pane, 5, 5);//(pane, totalLevels, currentLevel)
        /*try{
            FileInputStream fis = new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Zombies.GIF");
            Image image = new Image(fis);
            ImageView iv = new ImageView(image);
            System.out.println("INININ");
            pane.getChildren().add(iv);
            
            Path path = new Path();
            path.getElements().add(new MoveTo(450, col * 47));
            path.getElements().add(new LineTo(100, col * 47));
            
            //Line line = new Line();
            PathTransition transition = new PathTransition();
            transition.setDuration(Duration.seconds(3));
            transition.setNode(iv);
            transition.setPath(path);
            transition.setCycleCount(Timeline.INDEFINITE);
            transition.play();
            
            fis = new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/SnowBullet.PNG");
            image = new Image(fis);
            iv = new ImageView(image);
            pane.getChildren().add(iv);
            
            path = new Path();
            path.getElements().add(new MoveTo(5 * 50, 4 * 53));
            path.getElements().add(new LineTo(500, 4 * 53));
            
            transition = new PathTransition();
            transition.setDuration(Duration.seconds(3));
            transition.setNode(iv);
            transition.setPath(path);
            transition.setCycleCount(Timeline.INDEFINITE);
            transition.play();
            
        //    FileInputStream fis1 = new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/Zombies.GIF");
            
        }
        
        catch(Exception ex){
            System.out.println("CAUGHT");
        }*/
        for(rectRows=0; rectRows<rows; rectRows++){
            for(rectColumns =0; rectColumns<columns; rectColumns++){
                col -= 1;
                rectangle[rectRows][rectColumns].setOnMouseClicked((MouseEvent e) -> {
                    this.rectXCor.add((int)(e.getSceneY()/50));
                    this.rectYCor.add((int)(e.getSceneX()/50));
                    if(bar.getPlantType() != null){//make if condition more accurate
                        System.out.println("INSIDE");
                        System.out.println("LOCATION = " + bar.getPlantType().getLocation());
                        bar.getPlantType().setPosX((int)(e.getSceneY()/50));
                        bar.getPlantType().setPosY((int)(e.getSceneX()/50));
                        //try {
                        plantList.add(bar.getPlantType());
                        FileInputStream fis;
                        try {
                            String location = bar.getPlantType().getLocation();
                            if(bar.getPlantType().getClass() == PeaShooter.class){
                                location = location.substring(0, location.lastIndexOf(".")+1);
                                location = location + "GIF";
                            }
                            fis = new FileInputStream(location);
                            Image image = new Image(fis);
                            ImagePattern ip = new ImagePattern(image);
                            rectangle[(int)(e.getSceneY()/50)][(int)(e.getSceneX()/50)].setFill(ip);
                        } catch (IOException ex) {
                            //IOException Handled
                        }
                        bar.setPlantType(null);
                    }
                });
            }
        }
        sun = new Sun(pane, 100, 100);
        sun.addToPane();
        /*timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {try {
			sun.addToPane();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}} ));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();*/
        
        Path path = new Path();
        int pos = sun.getPosX();
		path.getElements().add(new MoveTo(pos, 40));
        path.getElements().add(new LineTo(pos, 480));
        
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(10));
        transition.setNode(sun.getImageView());
        transition.setPath(path);
        transition.setCycleCount(5);
        transition.play();
        sun.getImageView().setOnMouseClicked(e -> {
        	bar.getLabel().setText(Integer.toString(sun.getValue()));
        	sun.setValue(sun.getValue() + 50);
        	transition.pause();
        });
        
        
        //addToPane(pane, this.createTopLeftBar());
        //System.out.println(bar.getPlantType().getSunCost());
        return pane;
        
    }
    
    public void createLevel(int count)throws IOException{
        //Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/MenuImage.PNG", 500, 500);
        Pane pane = createPane();
        Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PlayerProfileBackground.PNG", 500, 250);
        label.setLayoutX(0);
        label.setLayoutY(125);
        int lblX = 15;
        int lblY = 125;
        int btnX = 30;
        int btnY = 335;
        int lvlX = 30;
        int lvlY = 150;
        addToPane(pane, menuBackground, label);
        Label[] label1 = new Label[5];
        Button[] btn = new Button[5];
        Label[] levelLbl = new Label[5];
        for(int i=0; i<5; i++){
            String lvl = "Level-" + (i+1);
            label1[i] = createImageLabel(lvl, "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/LevelPictures.PNG", 80, 125);
            label1[i].setMaxSize(80, 250);
            label1[i].setMinSize(80, 250);
            label1[i].setLayoutX(lblX);
            label1[i].setLayoutY(lblY);
            btn[i] = createButton("PLAY", btnX, btnY);
            levelLbl[i] = createTextLabel(lvl, lvlX, lvlY);
            if(i >= count){
                label1[i].setDisable(true);
                btn[i].setDisable(true);
            }
            Font font = new Font("Aerial", 24);
            levelLbl[i].setTextFill(Color.WHITE);
            lblX += 100;
            btnX += 100;
            lvlX += 100;
            btn[i].setOnAction(e -> {
                try{
                    Pane pane1 = this.createLawn(10, 10, 0, 0, 50, 50);
                    Scene scene1 = createScene(pane1, 500, 500);
                    window.setScene(scene1);
                }
                catch(IOException ex){
                    //IOException Handled
                }
            });
            addToPane(pane, label1[i], btn[i], levelLbl[i]);
        }
        menuBackground.setOnMouseClicked(e -> {
            try{
                startMenu();
            }
            catch(IOException ex){
                //IOException Handled
            }
        });
        System.out.println("IN CREATE LEVEL");
        Scene scene = createScene(pane, 500, 500);
        window.setScene(scene);
        
    }
    
    
    
    public void addToPane(Pane pane, Parent ...parent){
        pane.getChildren().addAll(parent);
    }
    
    
    public void btn1ConfirmationButton(Scene scene)throws InterruptedException{
        Font font = new Font("Aerial", 24);
        Label label = createTextLabel("Profile Created", 150, 140);
        label.setFont(font);
        Button okBtn = createButton("OK", 215, 180);
        Pane pane = createPane();
        pane.getChildren().addAll(menuBackground, label, okBtn);
        Scene scene1 = createScene(pane, 500, 500);
        window.setScene(scene1);
        okBtn.setOnAction(e -> {
            try {
                menu();
            } catch (IOException ex) {
                //Handling IOException
            }
        });
    }
    
    
    public void btn1BackButton(Scene scene)throws IOException{
        menu();
    }
    
    
    public void btn1Action(Scene scene){
        Pane btn1Pane = createPane();
        Button btn1ConfirmButton = createButton("Confirm", 150, 150);
        Button btn1BackButton = createButton("Back", 230, 150);
        Label btn1Label = createTextLabel("Username: ", 70, 120);
        TextField btn1TextField = createTextField(150, 115);
        btn1Pane.getChildren().addAll(menuBackground, btn1ConfirmButton, btn1BackButton, btn1Label, btn1TextField);
        Scene btn1Scene = createScene(btn1Pane, 500, 500);
        window.setScene(btn1Scene);
        btn1ConfirmButton.setOnAction(e -> {
            try{
                //System.out.println(btn1TextField.getText());
                String username = btn1TextField.getText();
                if(username.length() <= 0){
                    //menuBackground.setOnMouseClicked(e1 -> btn1Action(scene));
                    Label warningLabel = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PlayerProfileBackground.PNG", 390, 110);
                    warningLabel.setLayoutX(50);
                    warningLabel.setLayoutY(125);
                    //warningLabel.setOnMouseClicked(e1 -> btn1Action(scene));
                    Button backButton = createButton("BACK", 205, 190);
                    backButton.setOnAction(e1 -> btn1Action(scene));
                    Label textLabel = this.createTextLabel("USERNAME CANNOT BE EMPTY", 75, 150);
                    Font font = new Font("Aerial", 24);
                    textLabel.setFont(font);
                    textLabel.setTextFill(Color.GREEN);
                    Pane pane = createPane();
                    addToPane(pane, menuBackground, warningLabel, backButton, textLabel);
                    Scene scene1 = createScene(pane, 500, 500);
                    window.setScene(scene1);
                    
                }
                else{
                    profile.setPlayerName(btn1TextField.getText());
                    playerNameList = profile.getPlayerNameList();
                    btn1ConfirmationButton(scene);
                }
            }
            catch(Exception ex){
                //Handled InterruptedException
            }
        });
        btn1BackButton.setOnAction(e -> {
            try {
                btn1BackButton(scene);
            } catch (IOException ex) {
                //Handling IOEXception
            }
        });
    }
    
    
    public void btn2Action(int xCoordinate, int yCoordinate)throws IOException{
        Pane pane = createPane();
        Label profileBackground = createImageLabel("PROFILES", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PlayerProfileBackground.PNG", 500, 500);
        addToPane(pane, profileBackground);
        Font font= new Font("Aerial", 24);
        ToggleGroup tg = new ToggleGroup();
        if(profile.getPlayerNameList().size() == 0){
            Button btn = createButton("EMPTY", 200, 200);
            btn.setFont(font);
            addToPane(pane, btn);
            btn.setOnAction(e -> {
                try{
                    menu();
                }
                catch(IOException ex){
                    //IOException handled
                }
            });
        }
        else{
            RadioButton[] rb = new RadioButton[profile.getPlayerNameList().size()];
            
            for(int i=0; i<rb.length; i++){
                //lbl[i] = createTextLabel(playerNameList.get(i), xCoordinate, yCoordinate);
                rb[i] = new RadioButton(playerNameList.get(i));
                rb[i].setFont(font);
                rb[i].setLayoutX(xCoordinate);
                rb[i].setLayoutY(yCoordinate);
                /*if(playerNameList.get(i).equals("")){
                    System.out.println("NULL");
                }
                else{
                    System.out.println(playerNameList.get(i));
                }*/
                rb[i].setToggleGroup(tg);
                pane.getChildren().add(rb[i]);
                yCoordinate += 40;
            }
            rb[0].setSelected(true);
            yCoordinate += 40;
            Button loadButton = createButton("LOAD", xCoordinate - 80, yCoordinate);
            Button deleteButton = createButton("DELETE", xCoordinate, yCoordinate);
            Button renameButton = createButton("RENAME", xCoordinate + 90, yCoordinate);
            Button backButton = createButton("BACK", xCoordinate + 190, yCoordinate);

            backButton.setOnAction(e -> {
                try{
                    menu();
                }
                catch(IOException ex){
                    //IOException Handeled
                }
            });


            loadButton.setOnAction(e -> {
               try{
                   this.createLevel(1);
               } 
               catch(Exception ex){
                   //IOExceptionHandeled + Class Not Found Exception Handeled
               }
            });
            
            deleteButton.setOnAction(e -> {
                for(int i=0; i<this.playerNameList.size(); i++){
                    if(rb[i].isSelected()){
                        this.playerNameList.remove(i);
                        break;
                    }
                }
                try{
                    btn2Action(180, 200);
                }
                catch(IOException ex){
                    //IOException Handled
                }
            });
            //RENAME NOT WORKING CORRECTLY
            /*renameButton.setOnAction(e -> {
               for(int i=0; i<this.playerNameList.size(); i++){
                   if(rb[i].isSelected()){                                      //RENAME NOT WORKING CORRECTLY
                       System.out.println("REACHED");
                       btn1Action(menuBackgroundScene);
                       this.playerNameList.set(i, playerNameList.get(this.playerNameList.size()-1));
                       //this.playerNameList.remove(playerNameList.get(this.playerNameList.size()-1));
                       break;
                   }
               } 
               try{
                    btn2Action(180, 200);
                }
                catch(IOException ex){
                    //IOException Handled
                }
            });*/

            pane.getChildren().addAll(loadButton, backButton, renameButton, deleteButton);
        }
        
        Scene scene = createScene(pane, 500, 500);
        window.setScene(scene);
        
    }
    
    
    public void menu()throws IOException{
        Button btn1 = createButton("New Profile", 210, 175);
        Button btn2 = createButton("Existing Profile", 210, 215);
        Button btn3 = createButton("Back", 210, 255);
        //menuBackground = createImageLabel("MENU", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/MenuImage.PNG", 500, 500);
        Pane pane = createPane();
        pane.getChildren().addAll(menuBackground, btn1, btn2, btn3);
        menuBackgroundScene = createScene(pane, 500, 500);
        //window.setTitle("PLANTS VS ZOMBIES");
        window.setScene(menuBackgroundScene);
        btn1.setOnAction(e -> btn1Action(menuBackgroundScene));
        
        btn2.setOnAction(e -> {
            try {
                btn2Action(180, 200);
            } catch (IOException ex) {
                //IOException Handled
            }
        });
        
        
        btn3.setOnAction(e -> {
            try{
                startMenu();
            }
            catch(IOException ex){
                //IOExceptionHandled
            }
        });
        window.show();
    }
    
    
    public void exit(){
        System.exit(0);
    }
    
    
    public void save()throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/playerNameList.txt"));
        oos.writeObject(profile);
        oos.close();
        System.exit(0);
    }
    
    
    public void askSave()throws IOException{
        Pane pane = createPane();
        Label lbl = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PlayerProfileBackground.PNG", 300, 130);
        lbl.setLayoutX(125);
        lbl.setLayoutY(125);
        Label textLabel = this.createTextLabel("SAVE BEFORE EXIT", 180, 150);
        Font font = new Font("Aerial", 24);
        textLabel.setFont(font);
        textLabel.setTextFill(Color.WHITE);
        Button yesButton = createButton("Yes", 215, 185);
        Button noButton = createButton("No", 270, 185);
        pane.getChildren().addAll(menuBackground, lbl, textLabel, yesButton, noButton);
        noButton.setOnAction(e -> exit());
        yesButton.setOnAction(e -> {
            try{
                save();
            }
            catch(IOException ex){
                //handled IOException
            }
        });
        Scene scene = createScene(pane, 500, 500);
        window.setScene(scene);
    }
    
    
    public Pane askExit(Pane pane)throws IOException{
        Label label = createImageLabel("", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/PlayerProfileBackground.PNG", 300, 130);
        label.setLayoutX(125);
        label.setLayoutY(125);
        Label textLabel = this.createTextLabel("DO YOU WANT TO EXIT", 150, 150);
        Font font = new Font("Aerial", 24);
        textLabel.setFont(font);
        textLabel.setTextFill(Color.WHITE);
        Button yesButton = createButton("Yes", 215, 185);
        Button noButton = createButton("No", 270, 185);
        pane.getChildren().addAll(menuBackground, label, textLabel, yesButton, noButton);
        noButton.setOnAction(e -> {
            try{
                startMenu();
            }
            catch(IOException ex){
                //Handeled IOException
            }
        });
        yesButton.setOnAction(e -> {
            try{
                askSave();
            }
            catch(IOException ex){
                //handeled IOException
            }
        });
        return pane;
    }

    
    public void exitProcess() throws IOException{
        Pane pane = createPane();
        pane = askExit(pane);
        Scene scene = new Scene(pane, 500, 500);
        window.setScene(scene);
    }
    
    
    
    public void startMenu()throws IOException{
        menuBackground = createImageLabel("START MENU", "D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/Plants VS Zombies Images/MenuImage.PNG", 500, 500);
        Pane pane = createPane();
        addToPane(pane, menuBackground);
        Button[] btn = new Button[4];
        int btnX = 175;
        int btnY = 210;
        String[] btnOptions = {"New Game", "Resume Game", "Change Profile", "Exit Game"};
        for(int i=0; i<btnOptions.length; i++){
            btn[i] = createButton(btnOptions[i], btnX, btnY);
            btnY += 40;
            addToPane(pane, btn[i]);
        }
        Scene scene = createScene(pane, 500, 500);//1920, 1000
        
        btn[0].setOnAction(e -> {
            try{
                //EventHandler<MouseEvent> event = new EventHandler<>();
                this.createLevel(5);
            }
            catch(IOException ex){
                //IOException Handled
            }
        });
        btn[2].setOnAction(e -> {
           try{
               menu();
           } 
           catch(IOException ex){
               //IOException Handled
           }
        });
        btn[3].setOnAction(e -> {
            try{
                exitProcess();
            }
            catch(IOException ex){
                //IOException Handled
            }
        });
        
        window.setTitle("PLANTS VS ZOMBIES");
        window.setScene(scene);
        
    }
    
    
    @Override
    public void start(Stage primaryStage)throws IOException, ClassNotFoundException{
        
        window = primaryStage;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/NetBeans 8.0.2/Projects/PlantsVSZombies/src/playerNameList.txt"));
            profile = (PlayerProfile)ois.readObject();
            playerNameList = profile.getPlayerNameList();
            ois.close();
        }
        catch(Exception ex){
            
        }
        startMenu();
        window.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException {
        launch(args);
    }
    
}