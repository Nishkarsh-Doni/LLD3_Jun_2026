package org.example.tictactoe;

import org.example.tictactoe.controllers.GameController;
import org.example.tictactoe.exceptions.InvalidGameException;
import org.example.tictactoe.models.*;
import org.example.tictactoe.services.GameService;
import org.example.tictactoe.strategies.winning.ColumnWinningStrategy;
import org.example.tictactoe.strategies.winning.DiagonalWinningStrategy;
import org.example.tictactoe.strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) throws InvalidGameException {
        // Setup
        int boardSize = 3;

        Player player1 = new HumanPlayer("Shilpa", new Symbol('X'));
        Player player2 = new HumanPlayer("Deepashree", new Symbol('O'));

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Build the game(along with validations)
        Game game = Game.getGameBuilder()
                .setBoardSize(boardSize)
                .setPlayers(players)
                .setWinningStrategies(List.of(new ColumnWinningStrategy(), new RowWinningStrategy(), new DiagonalWinningStrategy()))
                .build();

        // Create Controller
        GameController controller = new GameController(new GameService());
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== TicTacToe====");
        // Print the players name who are in this game

        while (controller.getGameState(game) == GameState.IN_PROGRESS) {
            controller.printBoard(game);

            Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
            // Alok's turn (X):
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol().getCharacter() + "):");

            // Human makes a move via console
            System.out.println("Enter row and col (e.g., 0 1):");
            // 0 1
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+"); // ['2', '1']
            int row = Integer.parseInt(parts[0]); // 2
            int col = Integer.parseInt(parts[1]); // 1

            if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
                System.out.println("Invalid cell. Please try again in a valid cell");
                continue;
            }

            Cell cell = game.getBoard().getCell(row, col);

            if (cell.getCellState() != CellState.EMPTY) {
                System.out.println("Cell is already occupied! Try again. \n");
                continue;
            }

            Move move = new Move(currentPlayer, cell);
            controller.makeMove(game, move.getCell(), move.getPlayer());
        }

        // ---- GAME OVER ----
        controller.printBoard(game);

        if (game.getGameState() == GameState.ENDED) {
            System.out.println("Hurrah! " + game.getWinner().getName()  + " wins!");
        } else {
            System.out.println("It is a draw ;|");
        }

        scanner.close();
    }
}
