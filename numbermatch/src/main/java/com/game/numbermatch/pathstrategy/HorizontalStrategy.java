package com.game.numbermatch.pathstrategy;

import com.game.numbermatch.model.Cell;

public class HorizontalStrategy implements PathStrategy {

    @Override
    public boolean canConnect(Cell[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 != r2) {
            return false;
        }

        for (int c = Math.min(c1, c2) + 1; c < Math.max(c1, c2); c++) {
            if (!grid[r1][c].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
