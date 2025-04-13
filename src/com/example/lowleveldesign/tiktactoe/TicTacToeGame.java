package com.example.lowleveldesign.tiktactoe;

import com.example.lowleveldesign.tiktactoe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board boardGame;

    public TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();

        // Create 2 players
        PlayingPieceX playingPieceX = new PlayingPieceX();
        PlayingPieceO playingPieceO = new PlayingPieceO();

        Player player1 = new Player("Player 1", playingPieceX);
        Player player2 = new Player("Player 2", playingPieceO);

        players.add(player1);
        players.add(player2);

        // Initialize the board
        boardGame = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {

            // Take out the player whose turn it is and then add it back at last
            Player playerTurn = players.removeFirst();

            // Print the board
            boardGame.printBoard();

            // Get free spaces on the board
            List<int[]> freeSpaces = boardGame.getEmptyCells();

            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // Read the user input
            System.out.println("Player " + playerTurn.getPlayerName() + " enter row and column as row,column: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] values = input.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            // Place the piece
            boolean piecePlaced = boardGame.addPiece(inputRow, inputCol, playerTurn.getPlayingPiece());

            if (!piecePlaced) {
                // Player cannot place the piece in an already occupied space
                System.out.println("Invalid move. Try again.");
                players.addFirst(playerTurn);
                continue;
            }

            // Add the player at the end
            players.addLast(playerTurn);

            boolean winner = boardGame.checkForWinner(inputRow, inputCol, playerTurn.getPlayingPiece());

            if (winner) {
                // Print the winning board
                boardGame.printBoard();

                return playerTurn.getPlayerName();
            }
        }

        return "tie";
    }
}
