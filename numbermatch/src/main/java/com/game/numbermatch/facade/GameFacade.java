package com.game.numbermatch.facade;

import com.game.numbermatch.model.GameState;
import com.game.numbermatch.service.GameService;

/*
 DESIGN PATTERN: Facade
 واجهة بسيطة للـ Controller
 */
public class GameFacade {

    private final GameService service = new GameService();

    public GameState newGame() {
        return service.newGame();
    }

    public GameState match(int r1, int c1, int r2, int c2) {
        return service.tryMatch(r1, c1, r2, c2);
    }

    public GameState addLines() {
        return service.addThreeLines();
    }
}
