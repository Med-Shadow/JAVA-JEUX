package com.game.numbermatch.model;

public class Cell {
    private Integer value; 

    public Cell(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void clear() {
        this.value = null;
    }

    public boolean isEmpty() {
        return value == null;
    }
}
