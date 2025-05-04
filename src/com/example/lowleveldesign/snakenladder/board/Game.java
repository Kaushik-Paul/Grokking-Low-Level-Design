package com.example.lowleveldesign.snakenladder.board;

import com.example.lowleveldesign.snakenladder.dice.Dice;
import com.example.lowleveldesign.snakenladder.player.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        this.board = new Board(10, 8, 4);
        this.dice = new Dice(1);
        this.winner = null;
        addPlayers();
    }

    // Add players
    private void addPlayers() {
        this.players = new LinkedList<>();
        Player player1 = new Player("Player 1", 0);
        Player player2 = new Player("Player 2", 0);
        this.players.add(player1);
        this.players.add(player2);
    }

    // Start the game and play till there is a winner
    public void startGame() {
        while (this.winner == null) {

            // Get the player whose turn it is
            Player playerTurn = getPlayerTurn();
            System.out.println(STR."Player turn is: \{playerTurn.getPlayerId()} current position is: \{playerTurn.getCurrentPosition()}");

            // Roll the dice
            int diceRoll = this.dice.rollDice();
            System.out.println(STR."Dice rolled: \{diceRoll}");

            // Move the player
            int playerPosition = playerTurn.getCurrentPosition() + diceRoll;
            playerPosition = jumpCheck(playerPosition);
            playerTurn.setCurrentPosition(playerPosition);

            // Print player new position
            System.out.println(STR."Player \{playerTurn.getPlayerId()} new position is: \{playerTurn.getCurrentPosition()}");

            // Check whether we have winner
            if (playerPosition >= this.board.getBoardSize() * this.board.getBoardSize() - 1) {
                this.winner = playerTurn;
            }

            System.out.println("=============================================================================");
        }

        System.out.println(STR."Player \{this.winner.getPlayerId()} won the game");
    }

    // Get the player whose turn it is
    private Player getPlayerTurn() {
        Player player = this.players.removeFirst();
        this.players.addLast(player);
        return player;
    }


    // Check if the player has to jump or not
    private int jumpCheck(int playerPosition) {
        if (playerPosition > this.board.getBoardSize() * this.board.getBoardSize() - 1) {
            return playerPosition;
        }

        Cell cell = this.board.getCell(playerPosition);
        Jump jump = cell.getJump();

        if (jump != null && jump.getStart() == playerPosition) {
            String jumpBy = jump.getStart() > jump.getEnd() ? "Snake" : "Ladder";
            System.out.println(STR."Jump by \{jumpBy} from \{jump.getStart()} to \{jump.getEnd()}");
            return jump.getEnd();
        }

        return playerPosition;
    }
}
