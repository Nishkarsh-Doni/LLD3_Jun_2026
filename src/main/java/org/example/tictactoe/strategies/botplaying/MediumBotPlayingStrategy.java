package org.example.tictactoe.strategies.botplaying;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;
import org.example.tictactoe.models.Player;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        // TODO:: Implement a smarter strategy (block opponent, prefer center)
        return new EasyBotPlayingStrategy().makeMove(board, player);
    }
}
