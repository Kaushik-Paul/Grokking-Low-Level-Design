package com.example.lowleveldesign.snakenladder.board;

public class Jump {

    private int start;
    private int end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Jump() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
