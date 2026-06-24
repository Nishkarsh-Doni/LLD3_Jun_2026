package org.example.tictactoe.strategies.botplaying;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move getMove(Board board, Player player);
}
