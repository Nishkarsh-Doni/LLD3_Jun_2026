package org.example.tictactoe.models;

import org.example.tictactoe.exceptions.InvalidGameException;
import org.example.tictactoe.strategies.winning.WinningStrategy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    // Private constructor - only game Builder can create a game object
    private Game(Builder builder) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = builder.winningStrategies;

        // Randomize the players list
        Collections.shuffle(this.players);
    }

    // Getters
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public Player getWinner() {
        return winner;
    }
    public GameState getGameState() {
        return gameState;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public Board getBoard() {
        return board;
    }

    // Setters
    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    // Returns the Builder object
    public static Builder getGameBuilder() {
        return new Builder();
    }

    // ═══════════════════════════════════════════════
    //  BUILDER — validates and constructs the Game
    // ═══════════════════════════════════════════════
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
            // Validate player count: should be boardSize - 1
            if (players.size() != boardSize - 1) {
                throw new InvalidGameException(
                        "Player count must be " + (boardSize - 1) + " for a " + boardSize + "x" + boardSize + " board."
                );
            }

            // Validate unique symbols
            Set<Character> symbols = new HashSet<>();
            for (Player player : players) {
                char symbol = player.getSymbol().getCharacter();
                if (symbols.contains(symbol)) {
                    throw new InvalidGameException("Duplicate symbol found: " + symbol);
                }
                symbols.add(symbol);
            }

            // Validate at most one bot
            long botCount = players.stream()
                    .filter(p -> p.getPlayerType() == PlayerType.BOT)
                    .count();
            if (botCount > 1) {
                throw new InvalidGameException("At most 1 bot is allowed per game.");
            }
        }

        public Game build() throws InvalidGameException {
            validate();
            return new Game(this);
        }
    }
}
