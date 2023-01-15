package com.org.leetstats.enums;

public enum Level {

    EASY('E'),
    MEDIUM('M'),
    HARD('H');
    private final char l;
    Level(char l){
        this.l = l;
    }

    public char getType()  {return l;}
}
