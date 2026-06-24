package org.example.tictactoe.strategies.winning;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}

/*
Row winning strategy



 */
