package org.example.tictactoe;

import org.example.tictactoe.exceptions.InvalidGameException;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.HumanPlayer;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.models.Symbol;
import org.example.tictactoe.strategies.winning.ColumnWinningStrategy;
import org.example.tictactoe.strategies.winning.DiagonalWinningStrategy;
import org.example.tictactoe.strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    public static void main(String[] args) throws InvalidGameException {
        // Setup
        int boardSize = 3;

        // Scanner in = new Scanner(System.in);
        // System.out.println("Enter your symbol");
        // char symbol = in.next()[0];
        // Create players
        Player player1 = new HumanPlayer("Shilpa", new Symbol('X'));
        Player player2 = new HumanPlayer("Deepashree", new Symbol('O'));
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Game game = Game.getGameBuilder()
                .setBoardSize(boardSize)
                .setPlayers(players)
                .setWinningStrategies(List.of(new ColumnWinningStrategy(), new RowWinningStrategy(), new DiagonalWinningStrategy()))
                .build();



    }
}
