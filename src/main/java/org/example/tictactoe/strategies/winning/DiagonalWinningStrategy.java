package org.example.tictactoe.strategies.winning;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.CellState;
import org.example.tictactoe.models.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        int size = board.getSize();
        char symbol = lastMove.getPlayer().getSymbol().getCharacter();

        // Check main-diagonal (left to right)
        if (row == col) {
            boolean won = true;
            for (int i = 0; i < size; i++) {
                var cell = board.getCell(i, i);
                if (cell.getCellState() == CellState.EMPTY ||
                    cell.getPlayer().getSymbol().getCharacter() != symbol) {
                    won = false;
                    break;
                }
            }
            return won;
        }

        // Check anti-diagonal (right to left)
        if (row + col == size - 1) {
            for (int i = 0; i < size; i++) {
                // i + j = size - 1
                // j = size - 1- i
                var cell = board.getCell(i, size - 1- i);
                if (cell.getCellState() == CellState.EMPTY ||
                        cell.getPlayer().getSymbol().getCharacter() != symbol) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
