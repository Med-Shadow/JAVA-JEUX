package com.game.numbermatch.pathstrategy;

import com.game.numbermatch.model.Cell;

public class DiagonalStrategy implements PathStrategy {

    @Override
    public boolean canConnect(Cell[][] grid, int r1, int c1, int r2, int c2) {
        int di = r2 - r1, dj = c2 - c1;
        if (Math.abs(di) != Math.abs(dj)) {
            return false;
        }

        int stepR = di > 0 ? 1 : -1;
        int stepC = dj > 0 ? 1 : -1;

        int r = r1 + stepR, c = c1 + stepC;
        while (r != r2) { 
            if (!grid[r][c].isEmpty()) {
                return false;
            }
            r += stepR;
            c += stepC;
        }
        return true;
    }
}
