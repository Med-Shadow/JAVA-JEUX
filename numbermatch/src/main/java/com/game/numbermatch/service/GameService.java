package com.game.numbermatch.service;

import java.util.List;

import com.game.numbermatch.factory.CellFactory;
import com.game.numbermatch.logic.PathChecker;
import com.game.numbermatch.manager.GameManager;
import com.game.numbermatch.model.Cell;
import com.game.numbermatch.model.GameState;
import com.game.numbermatch.pathstrategy.DiagonalStrategy;
import com.game.numbermatch.pathstrategy.HorizontalStrategy;
import com.game.numbermatch.pathstrategy.VerticalStrategy;
import com.game.numbermatch.strategy.MatchStrategy;
import com.game.numbermatch.strategy.SameNumberStrategy;
import com.game.numbermatch.strategy.SumTenStrategy;

/*
 Service = منطق اللعبة كامل
 */
public class GameService {

    private final GameManager manager = GameManager.getInstance();
    private final int Ncols = 7;

    private final List<MatchStrategy> strategies = List.of(
            new SameNumberStrategy(),
            new SumTenStrategy()
    );

    public void addStrategies(MatchStrategy strategie) {
        strategies.add(strategie);
    }

    public GameState newGame() {
        int rows = 5, cols = Ncols;

        Cell[][] grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = CellFactory.createRandomCell();
            }
        }

        GameState game = new GameState(grid);
        manager.setGame(game);
        return game;
    }

    public GameState tryMatch(int r1, int c1, int r2, int c2) {

        GameState game = manager.getGame();
        Cell a = game.getGrid()[r1][c1];
        Cell b = game.getGrid()[r2][c2];

        if (a.isEmpty() || b.isEmpty()) {
            return game;
        }

        boolean numbersOk = false;
        for (MatchStrategy s : strategies) {
            if (s.isValid(a.getValue(), b.getValue())) {
                numbersOk = true;
                break;
            }
        }
        
        PathChecker checker = new PathChecker(List.of(
            new HorizontalStrategy(),
            new VerticalStrategy(),
            new DiagonalStrategy()
        ));

        boolean pathOk = checker.canConnect(game.getGrid(), r1, c1, r2, c2);


        if (numbersOk && pathOk) {
            a.clear();
            b.clear();
            game.score += 10;
        }
        return game;
    }

    public GameState addThreeLines() {

        GameState game = manager.getGame();
        if (game.remainingLines == 0) {
            return game;
        }
        game.remainingLines -= 1;

        int oldRows = game.getGrid().length;
        int cols = Ncols;

        Cell[][] newGrid = new Cell[oldRows + 3][cols];

        for (int i = 0; i < oldRows; i++) {
            newGrid[i] = game.getGrid()[i];
        }

        for (int i = oldRows; i < oldRows + 3; i++) {
            newGrid[i] = new Cell[cols];
            for (int j = 0; j < cols; j++) {
                newGrid[i][j] = CellFactory.createRandomCell();
            }
        }
        game.setGrid(newGrid);
        return game;
    }
}
