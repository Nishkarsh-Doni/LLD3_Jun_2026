package org.example.tictactoe.strategies.botplaying;

import org.example.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move getMove(Board board, Player player) {
        // Collect all the empty cells
        List<Cell> emptyCells = new ArrayList<>();
        for (var row : board.getCells()) {
            for (var cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    emptyCells.add(cell);
                }
            }
        }

        // Pick a random cell
        Random random = new Random();
        Cell chosenCell = emptyCells.get(random.nextInt(emptyCells.size()));

        return new Move(player, chosenCell);
    }
}
