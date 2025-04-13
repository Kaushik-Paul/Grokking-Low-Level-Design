package com.example.lowleveldesign.tiktactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if (this.board[row][col] != null) {
            return false;
        }

        this.board[row][col] = piece;
        return true;
    }

    public List<int[]> getEmptyCells() {
        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        return emptyCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

    public boolean checkForWinner(int inputRow, int inputCol, PlayingPiece playingPiece) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < size; i++) {
            // Check row
            if (board[inputRow][i] == null || 
                board[inputRow][i].getPieceType() != playingPiece.getPieceType()) {
                rowMatch = false;
            }
            
            // Check column
            if (board[i][inputCol] == null || 
                board[i][inputCol].getPieceType() != playingPiece.getPieceType()) {
                colMatch = false;
            }
        }
        
        // Only check diagonals if the piece is on a diagonal
        if (inputRow == inputCol) {
            for (int i = 0; i < size; i++) {
                if (board[i][i] == null || 
                    board[i][i].getPieceType() != playingPiece.getPieceType()) {
                    diagonalMatch = false;
                    break;
                }
            }
        } else {
            diagonalMatch = false;
        }
        
        // Only check anti-diagonals if the piece is on an anti-diagonal
        if (inputRow + inputCol == size - 1) {
            for (int i = 0; i < size; i++) {
                if (board[i][size - i - 1] == null || 
                    board[i][size - i - 1].getPieceType() != playingPiece.getPieceType()) {
                    antiDiagonalMatch = false;
                    break;
                }
            }
        } else {
            antiDiagonalMatch = false;
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
