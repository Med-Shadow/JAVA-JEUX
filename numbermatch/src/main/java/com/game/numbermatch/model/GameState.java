package com.game.numbermatch.model;

public class GameState {

    public Cell[][] grid;
    public int score;
    public int remainingLines;
    public boolean gameOver;
    public int addlinesNumber;

    public GameState(Cell[][] grid) {
        this.grid = grid;
        this.score = 0;
        this.remainingLines = 5;
        this.addlinesNumber = 0;
        this.gameOver = false;
    }

    public Cell[][] getGrid() {
        return this.grid;
    }
    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

}
