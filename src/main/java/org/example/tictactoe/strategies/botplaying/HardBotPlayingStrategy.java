package org.example.tictactoe.strategies.botplaying;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Player;

public class HardBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move getMove(Board board, Player player) {
        // TODO:: Implement minimax algorithm
        return new EasyBotPlayingStrategy().getMove(board, player);
    }
}
