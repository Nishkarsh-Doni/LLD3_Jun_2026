package org.example.tictactoe.controllers;

import org.example.tictactoe.models.Cell;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.GameState;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.services.GameService;

public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void makeMove(Game game, Cell cell, Player player) {
        gameService.makeMove(game, player, cell);
    }

    public void undoMove(Game game) {
        gameService.undoMove(game);
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void printBoard(Game game) {
        game.getBoard().printBoard();
    }
}
