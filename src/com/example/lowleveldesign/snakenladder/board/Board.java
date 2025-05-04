package com.example.lowleveldesign.snakenladder.board;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakeAndLadder(numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        this.cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int cellNumber = (i * cells.length) + j;
                cells[i][j] = new Cell(cellNumber);
            }
        }
    }

    private void addSnakeAndLadder(int numberOfSnakes, int numberOfLadders) {
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, this.cells.length * this.cells.length - 1);
            int snakeTail = snakeHead - ThreadLocalRandom.current().nextInt(1, snakeHead);

            Jump snakeObj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(snakeObj);

            numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, this.cells.length * this.cells.length - 1);
            int ladderTail = ladderHead + ThreadLocalRandom.current().nextInt(ladderHead, this.cells.length * this.cells.length - 1);

            Jump ladderObj = new Jump(ladderHead, ladderTail);
            Cell cell = getCell(ladderHead);
            cell.setJump(ladderObj);

            numberOfLadders--;
        }

    }

    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardCol = playerPosition % cells.length;
        return this.cells[boardRow][boardCol];
    }

    public int getBoardSize() {
        return cells.length;
    }
}
