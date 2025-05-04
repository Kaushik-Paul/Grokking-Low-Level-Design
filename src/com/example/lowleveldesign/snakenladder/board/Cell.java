package com.example.lowleveldesign.snakenladder.board;

public class Cell {

    private Jump jump;
    private int cellNumber;

    public Cell(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Cell(Jump jump) {
        this.jump = jump;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
