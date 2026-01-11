package com.game.numbermatch.logic;
import com.game.numbermatch.model.Cell;
import com.game.numbermatch.pathstrategy.PathStrategy;
import java.util.List;

public class PathChecker {

    private final List<PathStrategy> strategies;

    public PathChecker(List<PathStrategy> strategies) {
        this.strategies = strategies;
    }

    public boolean canConnect(Cell[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return false;
        }
        for (PathStrategy s : strategies) {
            if (s.canConnect(grid, r1, c1, r2, c2)) {
                return true; 
            }
        }
        return false; 

    }
}
