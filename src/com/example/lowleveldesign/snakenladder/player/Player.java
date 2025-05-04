package com.example.lowleveldesign.snakenladder.player;

public class Player {
    private String playerId;
    private int currentPosition;

    public Player(String playerId, int currentPosition) {
        this.playerId = playerId;
        this.currentPosition = currentPosition;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
