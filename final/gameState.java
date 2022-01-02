package sample;

import java.io.Serializable;

public class gameState implements Serializable {

    private String playerName;
    private int position;
    private int weapons;
    private int coins;
    private int score;
    private NewGame game;


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public NewGame getGame() {
        return game;
    }

    public void setGame(NewGame game) {
        this.game = game;
    }
}