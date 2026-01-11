package com.game.numbermatch.pathstrategy;
import com.game.numbermatch.model.Cell;
public interface PathStrategy {

    boolean canConnect(Cell[][] grid, int r1, int c1, int r2, int c2);
}
