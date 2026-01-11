package com.game.numbermatch.pathstrategy;

import com.game.numbermatch.model.Cell;

public class VerticalStrategy implements PathStrategy {

    @Override
    public boolean canConnect(Cell[][] grid, int r1, int c1, int r2, int c2) {
        if (c1 != c2) {
            return false;
        }

        for (int r = Math.min(r1, r2) + 1; r < Math.max(r1, r2); r++) {
            if (!grid[r][c1].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
