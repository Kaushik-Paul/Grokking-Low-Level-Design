package com.example.lowleveldesign.tiktactoe;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        System.out.println("The winner of the game is: " + ticTacToeGame.startGame());
    }
}
