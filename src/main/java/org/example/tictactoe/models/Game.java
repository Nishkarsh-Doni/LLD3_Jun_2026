package org.example.tictactoe.models;

import org.example.tictactoe.exceptions.InvalidGameException;
import org.example.tictactoe.strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public List<Move> getMoves() {
        return moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Board getBoard() {
        return board;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    private Game(Builder builder) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;

        // Randomize the players list
        Collections.shuffle(this.players);
    }

    public static Builder getGameBuilder() {
        return new Builder();
    }


    // Builder class
    public static class Builder {
        private int boardSize;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        // validations before creating the game
        private void validate() throws InvalidGameException {
            // validate the player count
            if (players.size() != boardSize - 1) {
                throw new InvalidGameException(
                        "Player count must be " + (boardSize - 1) + " for a " + boardSize +
                                "x" + boardSize + " board"
                );
            }
            // validate unique symbols

            // validate at most one bot player

        }

        public Game build() throws InvalidGameException {
            validate();
            return new Game(this);
        }
    }
}
