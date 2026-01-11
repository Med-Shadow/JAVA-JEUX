package com.game.numbermatch.strategy;

/*
 DESIGN PATTERN: Strategy
 نغيّر قواعد المطابقة بدون تغيير الكود الرئيسي
 */
public interface MatchStrategy {

    boolean isValid(int a, int b);
}
