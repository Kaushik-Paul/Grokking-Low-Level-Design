## Problem Definition -
A **Tic-Tac-Toe** game is a classic two-player strategy game played on a 3×3 grid. Players take turns placing their respective pieces (X or O) on the board, with the objective of getting three of their pieces in a row, column, or diagonal. The game has been implemented as a console-based application where players can interact through the command-line interface.

Tic-Tac-Toe is one of the earliest strategy games that teaches pattern recognition, spatial reasoning, and basic game theory. Despite its simple rules, it provides an excellent foundation for understanding fundamental concepts in game design and implementation.

## Requirements - 
1. **Game Board**: The game should be played on a 3×3 board represented as a two-dimensional grid.
2. **Players**: There should be two players, one using 'X' and the other using 'O' pieces.
3. **Turn-Based Gameplay**: Players should take turns placing their pieces on empty cells of the board.
4. **Move Validation**: The game should validate moves to ensure players cannot place pieces on already occupied cells.
5. **Win Condition Checking**: The game should check for a winner after each move by examining:
   - All rows (horizontal lines)
   - All columns (vertical lines)
   - Both diagonals (top-left to bottom-right and top-right to bottom-left)
6. **Game Termination**: The game should end when:
   - A player wins by forming a line of three of their pieces
   - The board is full with no winner (resulting in a tie)
7. **Board Visualization**: The board should be displayed after each move to show the current state of the game.
8. **User Input**: Players should input their moves through the console by specifying row and column coordinates in the format "row,column".
9. **Result Announcement**: The game should announce the winner or declare a tie at the end of the game.
10. **Error Handling**: The game should handle invalid inputs and provide appropriate error messages.

## System Design -

### Class Structure
The game is implemented using the following classes:

1. **Main**: Entry point of the application that initializes and starts the game.
2. **TicTacToeGame**: Core game controller that manages the game flow, player turns, and win condition checking.
3. **Board**: Represents the game board and contains methods for adding pieces, checking for winners, and displaying the board state.
4. **Player**: Represents a player with a name and an associated playing piece.
5. **PlayingPiece**: Abstract base class for the game pieces.
6. **PlayingPieceX**: Concrete implementation of the X piece.
7. **PlayingPieceO**: Concrete implementation of the O piece.
8. **PieceType**: Enum defining the types of pieces (X and O).

### Design Patterns Used

1. **Factory Pattern**: Used for creating different types of playing pieces.
2. **Model-View-Controller (MVC)**: The system separates the game logic (model), display (view), and game control (controller).
3. **Iterator Pattern**: Used for traversing through the collection of players for turn management.

### Game Flow

1. The game initializes with an empty 3×3 board and two players.
2. Players take turns placing their pieces on the board.
3. After each move, the system checks if the current player has won.
4. If a player wins, the game announces the winner and ends.
5. If the board becomes full without a winner, the game declares a tie.

## How to Play -

1. Run the Main class to start the game.
2. The game will display the empty board.
3. Player 1 (X) will be prompted to enter their move in the format "row,column" (e.g., "0,0" for the top-left cell).
4. The game will validate the move and update the board.
5. Player 2 (O) will then be prompted for their move.
6. This process continues until a player wins or the game ends in a tie.
7. The final result will be displayed, and the game will terminate.