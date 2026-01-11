package com.game.numbermatch.factory;

import java.util.Random;

import com.game.numbermatch.model.Cell;
public class CellFactory {

    private static final Random rand = new Random();

    public static Cell createRandomCell() {
        return new Cell(rand.nextInt(1,10) );
    }
}
