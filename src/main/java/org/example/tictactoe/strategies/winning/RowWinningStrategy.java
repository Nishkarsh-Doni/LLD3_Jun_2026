package org.example.tictactoe.strategies.winning;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Cell;
import org.example.tictactoe.models.CellState;
import org.example.tictactoe.models.Move;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        List<Cell> rowCells = board.getCells().get(row);
        char symbol = lastMove.getPlayer().getSymbol().getCharacter();

        for (Cell cell : rowCells) {
            if (cell.getCellState() == CellState.EMPTY
                    || cell.getPlayer().getSymbol().getCharacter() != symbol) {
                return false;
            }
        }
        return true;
    }
}
