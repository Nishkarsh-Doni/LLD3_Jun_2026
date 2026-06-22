package org.example.tictactoe.strategies.winning;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        return false;
    }
}
