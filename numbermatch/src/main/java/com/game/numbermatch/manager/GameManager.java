package com.game.numbermatch.manager;

import com.game.numbermatch.model.GameState;
public class GameManager {

    private static GameManager instance;
    private GameState game;

    private GameManager() {
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public GameState getGame() {
        return game;
    }

    public void setGame(GameState game) {
        this.game = game;
    }
}
