package org.example.tictactoe.services;

import org.example.tictactoe.models.*;
import org.example.tictactoe.strategies.winning.WinningStrategy;

public class GameService {
    public void makeMove(Game game, Player player, Cell cell) {
        // Make move
        // 1. make the move on the board
        // 2. is this a winning move
        // 3. is this a draw
        // 4. update the next player index
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(player);

        Move move = new Move(player, cell);
        game.getMoves().add(move);

        if (checkWinner(game, move)) {
            // won the game
            game.setWinner(player);
            game.setGameState(GameState.ENDED);
            return;
        }

        if (checkDraw(game)) {
            game.setGameState(GameState.DRAW);
            return;
        }

        int nextPlayer = (game.getNextPlayerIndex() + 1) % game.getPlayers().size();
        game.setNextPlayerIndex(nextPlayer);
    }

    private boolean checkWinner(Game game, Move lastMove) {
        // For this game, what are the winning strategies?
        for (WinningStrategy winningStrategy: game.getWinningStrategies()) {
            if (winningStrategy.checkWinner(game.getBoard(), lastMove)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw(Game game) {
        int size = game.getBoard().getSize();
        int totalCells = size * size;
        return game.getMoves().size() == totalCells;
    }

    public void undoMove(Game game) {
        // TODO:: Implement me!
    }
}
