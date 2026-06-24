package org.example.tictactoe.strategies.winning;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.CellState;
import org.example.tictactoe.models.Move;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        char symbol = lastMove.getPlayer().getSymbol().getCharacter();

        for (int i = 0; i < board.getSize(); i++) {
            var cell = board.getCell(i, col);
            if (cell.getCellState() == CellState.EMPTY
                    || cell.getPlayer().getSymbol().getCharacter() != symbol) {
                return false;
            }
        }
        return true;
    }
}
