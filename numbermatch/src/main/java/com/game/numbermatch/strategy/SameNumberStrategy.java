package com.game.numbermatch.strategy;

public class SameNumberStrategy implements MatchStrategy {

    @Override
    public boolean isValid(int a, int b) {
        return a == b;
    }
}
