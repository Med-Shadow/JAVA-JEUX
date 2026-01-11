package com.game.numbermatch.strategy;

public class SumTenStrategy implements MatchStrategy {

    @Override
    public boolean isValid(int a, int b) {
        return a + b == 10;
    }
}
