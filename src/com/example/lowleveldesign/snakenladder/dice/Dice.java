package com.example.lowleveldesign.snakenladder.dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceCount;
    private int min;
    private int max;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
        this.min = 1;
        this.max = 6;
    }

    public Dice(int diceCount, int min, int max) {
        this.diceCount = diceCount;
        this.min = min;
        this.max = max;
    }

    public int rollDice() {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return sum;
    }

}
