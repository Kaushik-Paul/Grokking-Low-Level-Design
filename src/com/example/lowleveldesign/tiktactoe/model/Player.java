package com.example.lowleveldesign.tiktactoe.model;

public class Player {
    private String playerName;
    private PlayingPiece playingPiece;

    public Player(String playerName, PlayingPiece playingPiece) {
        this.playerName = playerName;
        this.playingPiece = playingPiece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
