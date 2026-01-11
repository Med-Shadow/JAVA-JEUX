package com.game.numbermatch.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.numbermatch.facade.GameFacade;
import com.game.numbermatch.model.GameState;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {

    private final GameFacade facade = new GameFacade();

    @GetMapping("/new")
    public GameState newGame() {
        return facade.newGame();
    }

    @PostMapping("/match")
    public GameState match(
            @RequestParam int r1,
            @RequestParam int c1,
            @RequestParam int r2,
            @RequestParam int c2) {
        return facade.match(r1, c1, r2, c2);
    }

    @PostMapping("/add-lines")
    public GameState addLines() {
        return facade.addLines();
    }
}
